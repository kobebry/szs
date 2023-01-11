package ai.szs.szsapi.common.model;

import lombok.Data;

@Data
public class ResponseObject {

    public String resultCode;

    public String resultMessage;

    public Object responseDto;

    public ResponseObject(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public ResponseObject(String resultCode, String resultMessage, Object responseDto) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.responseDto = responseDto;
    }
}
