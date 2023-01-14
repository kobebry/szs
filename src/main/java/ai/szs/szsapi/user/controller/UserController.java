package ai.szs.szsapi.user.controller;


import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.config.JwtTokenProvider;
import ai.szs.szsapi.db.domain.Member;
import ai.szs.szsapi.signup.model.SignUpSetDto;
import ai.szs.szsapi.user.model.UserRefundGetDto;
import ai.szs.szsapi.user.model.UserScrapSetDto;
import ai.szs.szsapi.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/szs")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "szs - 유저 정보조회")
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    /**
     * szs - 회워정보 조회
     * **/
    @ResponseBody
    @GetMapping("/me")
    @ApiOperation(value = "szs - 회워정보 조회")
    public Member me(@RequestHeader HttpHeaders headers){

        String jwt = headers.getFirst("authorization");//header jwt 토큰 값 가져오기
        Claims claims = null;
        try{
            claims = jwtTokenProvider.parseJwtToken(jwt);
        }catch (Exception e){
            throw new RuntimeException("유효한 토큰이 아닙니다");
        }

        return userService.getMemberInfo(claims.get("memberIdx").toString());
    }

    /**
     * szs - 유저 스크랩
     * **/
    @ResponseBody
    @PostMapping("/scrap")
    @ApiOperation(value = "szs - 유저 스크랩")
    public ResponseObject scrap(@RequestHeader HttpHeaders headers, @RequestBody UserScrapSetDto userScrapSetDto) throws JSONException {

        String jwt = headers.getFirst("authorization");//header jwt 토큰 값 가져오기
        Claims claims = null;
        try{
            claims = jwtTokenProvider.parseJwtToken(jwt);
        }catch (Exception e){
            throw new RuntimeException("유효한 토큰이 아닙니다");
        }

        return userService.getScrap(claims.get("memberIdx").toString());
    }

    /**
     * szs - 유저 스크랩
     * **/
    @ResponseBody
    @GetMapping("/refund")
    @ApiOperation(value = "szs - 결정세액, 퇴직연금세액공제금액 계산")
    public UserRefundGetDto refund(@RequestHeader HttpHeaders headers) throws JSONException {

        String jwt = headers.getFirst("authorization");//header jwt 토큰 값 가져오기
        Claims claims = null;
        try{
            claims = jwtTokenProvider.parseJwtToken(jwt);
        }catch (Exception e){
            throw new RuntimeException("유효한 토큰이 아닙니다");
        }

        return userService.getRefund(claims.get("memberIdx").toString());
    }


}
