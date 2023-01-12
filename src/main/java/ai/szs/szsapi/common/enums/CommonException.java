package ai.szs.szsapi.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonException {

    SUCCESS("0000", "정상처리됐습니다"),

    SIGNUP_PARAM_VALID_ERROR("1001", "회원가입 필수값 누락 : "),
    SIGNUP_ALREADY_MEMBER("1002", "이미 가입된 회원입니다."),
    SIGNUP_NOT_AVAILABLE_USER("1003", "등록가능한 유저 정보가 아닙니다."),

    LOGIN_PARAM_VALID_ERROR("1011", "로그인 필수값 누락 : "),
    LOGIN_NOT_IN_USER("1012", "등록된 아이디가 아닙니다."),
    LOGIN_NOT_EQUAL_PASSWORD("1012", "비밀번호가 일치하지 않습니다."),



    PARAM_VALID_ERROR("5001", "필수값 누락");



    private String resultcode;
    private String resultMessage;
}
