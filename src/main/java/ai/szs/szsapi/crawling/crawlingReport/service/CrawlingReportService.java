package ai.szs.szsapi.crawling.crawlingReport.service;



import ai.szs.szsapi.common.model.DataTable;
import ai.szs.szsapi.crawling.crawlingReport.model.CrawlingReportGetDto;
import ai.szs.szsapi.crawling.crawlingReport.model.CrawlingReportSetDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrawlingReportService {


    private final CrawlingReportRepository crawlingReportRepository;


    public DataTable getCrawlingReportList(CrawlingReportSetDto crawlingReportSetDto){
        int page = crawlingReportSetDto.getStart() / crawlingReportSetDto.getLength();
        PageRequest pageRequest = PageRequest.of(page,crawlingReportSetDto.getLength());
        Page<CrawlingReportGetDto> responseList = null;


        //전체 조회
        if(StringUtils.isEmpty(crawlingReportSetDto.getField()) && StringUtils.isEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isEmpty(crawlingReportSetDto.getItemName())){
            responseList = crawlingReportRepository.getList(crawlingReportSetDto.getPIdx(), pageRequest);
        }else{
            //분야 조회
            if(StringUtils.isNotEmpty(crawlingReportSetDto.getField()) && StringUtils.isEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isEmpty(crawlingReportSetDto.getItemName())){
                responseList = crawlingReportRepository.getListField(crawlingReportSetDto.getPIdx(), crawlingReportSetDto.getField(), pageRequest);
            }

            //분야,산업 조회
            if(StringUtils.isNotEmpty(crawlingReportSetDto.getField()) && StringUtils.isNotEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isEmpty(crawlingReportSetDto.getItemName())){
                responseList = crawlingReportRepository.getListFieldAndIndustry(crawlingReportSetDto.getPIdx(), crawlingReportSetDto.getField(), crawlingReportSetDto.getIndustry(), pageRequest);

            }

            //분야,산업,품목명 조회
            if(StringUtils.isNotEmpty(crawlingReportSetDto.getField()) && StringUtils.isNotEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingReportSetDto.getItemName())){
                responseList = crawlingReportRepository.getListFieldAndIndustryAndItemName(crawlingReportSetDto.getPIdx(), crawlingReportSetDto.getField(), crawlingReportSetDto.getIndustry(), crawlingReportSetDto.getItemName(), pageRequest);
            }

            //산업 조회
            if(StringUtils.isEmpty(crawlingReportSetDto.getField()) && StringUtils.isNotEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isEmpty(crawlingReportSetDto.getItemName())){
                responseList = crawlingReportRepository.getListIndustry(crawlingReportSetDto.getPIdx(), crawlingReportSetDto.getIndustry(), pageRequest);
            }

            //산업,품목명 조회
            if(StringUtils.isEmpty(crawlingReportSetDto.getField()) && StringUtils.isNotEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingReportSetDto.getItemName())){
                responseList = crawlingReportRepository.getListIndustryAndItemName(crawlingReportSetDto.getPIdx(), crawlingReportSetDto.getIndustry(), crawlingReportSetDto.getItemName(), pageRequest);
            }

            //품목명 조회
            if(StringUtils.isEmpty(crawlingReportSetDto.getField()) && StringUtils.isEmpty(crawlingReportSetDto.getIndustry()) && StringUtils.isNotEmpty(crawlingReportSetDto.getItemName())){
                responseList = crawlingReportRepository.getListItemName(crawlingReportSetDto.getPIdx(), crawlingReportSetDto.getItemName(), pageRequest);

            }
        }

        return DataTable.builder()
                .data(Collections.singletonList(responseList))
                .recordsTotal(responseList.getTotalElements())
                .recordsFiltered(responseList.getTotalElements())
                .draw(crawlingReportSetDto.getDraw())
                .start(crawlingReportSetDto.getStart())
                .build();
    }


}


