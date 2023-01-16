package ai.szs.szsapi.user.service;


import ai.szs.szsapi.common.enums.CommonException;
import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.db.domain.*;
import ai.szs.szsapi.db.repository.MemberRepository;
import ai.szs.szsapi.db.repository.SalaryRepository;
import ai.szs.szsapi.db.repository.TaxAmountRepository;
import ai.szs.szsapi.db.repository.TaxCreditRepository;
import ai.szs.szsapi.user.model.JsonList;
import ai.szs.szsapi.user.model.UserRefundGetDto;
import ai.szs.szsapi.user.model.UserScrapGetDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final MemberRepository memberRepository;

    private final SalaryRepository salaryRepository;

    private final TaxAmountRepository taxAmountRepository;

    private final TaxCreditRepository taxCreditRepository;

    public Member getMemberInfo(String memberIdx){
        return memberRepository.findById(Long.parseLong(memberIdx)).get();
    }

    public ResponseObject getScrap(String memberIdx) throws JSONException {
        log.info("[getScrap: {}]", memberIdx);
        Optional<Member> member =  memberRepository.findById(Long.parseLong(memberIdx));

        if(member.isEmpty()){
            return new ResponseObject(CommonException.SCRAP_USER_ERROR.getResultcode(), CommonException.SCRAP_USER_ERROR.getResultMessage());
        }
        /* 1.급여 정보 조회 */
        LocalDate now = LocalDate.now();
        List<SalaryList> salaryList = salaryRepository.findAllByAndUserId(member.get().getUserId(), String.valueOf(now.getYear()));

        /* 2.급여 정보 조회 결과 */
        if(salaryList.isEmpty()){
            return new ResponseObject(CommonException.SCRAP_EMPTY_SALARY.getResultcode(), CommonException.SCRAP_EMPTY_SALARY.getResultMessage());
        }
        /* 3.산출세액 조회 */
        Optional<TaxAmount> taxAmount = taxAmountRepository.findByUserId(member.get().getUserId());

        /* 4.소득공제 조회 */
        List<TaxCredit> taxCreditList = taxCreditRepository.findAllByUserId(member.get().getUserId());

        List<Map> 소득공제 =new ArrayList<>();
        for(TaxCredit taxCredit : taxCreditList){
            Map<String, String> map = new HashMap<>();
            if(taxCredit.get소득구분().equals("퇴직연금")){
                map.put("총납입금액", taxCredit.get금액());
            }else{
                map.put("금액", taxCredit.get금액());
            }
            map.put("소득구분", taxCredit.get소득구분());
            소득공제.add(map);
        }

        JsonList jsonList = JsonList.builder()
                                    .급여(salaryList)
                                    .산출세액(taxAmount.get().get산출세액())
                                    .소득공제(소득공제)
                                    .appVer("2021112501")
                                    .company("삼쩜삼")
                                    .svcCd("test01")
                                    .hostNm("jobis-codetest")
                                    .workerReqDt("2022-08-16T06:27:35.160789")
                                    .workerResDt("2022-08-16T06:27:35.160851")
                                    .build();

        /* response */
        return new ResponseObject(CommonException.SUCCESS.getResultcode(), CommonException.SUCCESS.getResultMessage(), UserScrapGetDto.builder().jsonList(jsonList).build());
    }

    public UserRefundGetDto getRefund(String memberIdx) {
        log.info("[getRefund: {}]", memberIdx);
        Optional<Member> member =  memberRepository.findById(Long.parseLong(memberIdx));

        /* 1.급여 정보 조회 */
        LocalDate now = LocalDate.now();
        List<SalaryList> salaryList = salaryRepository.findAllByAndUserId(member.get().getUserId(), String.valueOf(now.getYear()));
        double 급여 = Double.parseDouble(salaryList.get(0).get총지급액().replace(",",""));

        /* 2.산출세액 조회 */
        Optional<TaxAmount> taxAmount = taxAmountRepository.findByUserId(member.get().getUserId());
        double 산출세액 = Double.parseDouble(taxAmount.get().get산출세액().replace(",",""));

        //근로소득세액공제금액
        double 근로소득세액공제금액 = Double.parseDouble(taxAmount.get().get산출세액().replace(",","")) * 0.55;

        /* 3.소득공제 조회 */
        List<TaxCredit> taxCreditList = taxCreditRepository.findAllByUserId(member.get().getUserId());

        double 특별세액공제금액 = 0;
        double 퇴직연금세액공제금액 = 0;

        //특별세액공제금액 구하기
        for(TaxCredit taxCredit : taxCreditList){
            double 보험료공제금액 = 0;
            double 의료비공제금액 = 0;
            double 교육비공제금액 = 0;
            double 기부금공제금액 = 0;

            if(taxCredit.get소득구분().equals("보험료")){//보험료공제금액
                보험료공제금액 = Double.parseDouble(taxCredit.get금액().replace(",",""))*0.12;
            }

            if(taxCredit.get소득구분().equals("의료비")){//의료비공제금액
                의료비공제금액 = (Double.parseDouble(taxCredit.get금액().replace(",","")) - 급여 * 0.02) * 0.15;
                의료비공제금액 = 의료비공제금액 < 0 ? 0 : 의료비공제금액;
            }

            if(taxCredit.get소득구분().equals("교육비")){//교육비공제금액
                교육비공제금액 = Double.parseDouble(taxCredit.get금액().replace(",","")) * 0.15;
            }

            if(taxCredit.get소득구분().equals("기부금")){//교육비공제금액
                기부금공제금액 = Double.parseDouble(taxCredit.get금액().replace(",","")) * 0.15;
            }

            if(taxCredit.get소득구분().equals("퇴직연금")){//퇴직연금세액공제금액
                퇴직연금세액공제금액 = Double.parseDouble(taxCredit.get금액().replace(",","")) * 0.15;
            }

            특별세액공제금액 = 보험료공제금액 + 의료비공제금액 + 교육비공제금액 + 기부금공제금액;
        }

        //표준세액공제금액 구하기
        double 표준세액공제금액 = 특별세액공제금액 >= 1300000 ? 0 : 특별세액공제금액;

        //결정세액 구하기
        double 결정세액 = 산출세액 - 근로소득세액공제금액 - 특별세액공제금액 - 표준세액공제금액 - 퇴직연금세액공제금액;

        DecimalFormat decFormat = new DecimalFormat("#,###");
        return UserRefundGetDto.builder().결정세액(결정세액 < 0 ? "0" : decFormat.format(결정세액)).퇴직연금세액공제(decFormat.format(퇴직연금세액공제금액)).이름(member.get().getName()).build();
    }
}
