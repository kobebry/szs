package ai.szs.szsapi.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonException {

    SUCCESS("0000", "정상처리됐습니다"),

    PARAM_VALID_ERROR("1001", "필수값 누락"),

    MEMBER_IS_EMPTY_MEMBER("3001", "회원정보가 존재하지 않습니다."),
    MEMBER_NOT_CONFIRM_PASSWORD("3002", "새 비밀번호가 일치하지 않습니다"),
    MEMBER_NOT_MATCHED_PASSWORD("3003", "현재 비밀번호가 일치하지 않습니다."),
    MEMBER_MATCHED_NEW_AND_OLD_PASSWORD("3004", "현재 사용 중인 비밀번호와 동일합니다."),
    MEMBER_EMAIL_SMTP_INSERTED_SMTP("3005", "이미 등록된 SMTP정보 입니다."),
    MEMBER_IS_REG_MEMBER("3006", "이미 등록된 ID입니다."),


    WORK_ISEMPTY_PROJECT("4001", "프로젝트가 존재하지 않습니다."),
    WORK_ISEMPTY_WORK("4002", "작업이 존재하지 않습니다."),

    CODE_ISEMPTY_CODE("7000", "필드값이 존재하지 않습니다."),
    CODE_IS_REG_CODE("7001", "필드값 등록 실패, 이미 등록된 값이 있습니다."),

    UPLOAD_EXCEL_FILE_COMPANY_FAILED("8001", "기업연계표 업로드 시 오류가 발생했습니다."),
    SIGNUP_NOT_MATCHED_MEMBER("8002", "인증 실패, 일치하는 회원정보가 없습니다."),
    SIGNUP_ALREADY_AUTH_MEMBER("8003", "이미 인증이 완료된 회원입니다."),
    SIGNUP_SEND_MAIL_CNT_OVER("8004", "이메일 재발송 건수를 초과했습니다.\n" +"이용에 어려움이 있으신 경우 바티 서포트(support@bati.ai) 팀으로 연락 바랍니다.");



    private String resultcode;
    private String resultMessage;
}
