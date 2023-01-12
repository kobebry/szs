package ai.szs.szsapi.common.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseObject {

    public String status;

    public String resultMessage;

    public List<String> errors;

    public Object data;

    public ResponseObject(String status, String resultMessage) {
        this.status = status;
        this.resultMessage = resultMessage;
    }

    public ResponseObject(String status, String resultMessage, Object data) {
        this.status = status;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    public ResponseObject(String status, String resultMessage, Object data, List<String> errors) {
        this.status = status;
        this.resultMessage = resultMessage;
        this.data = data;
        this.errors = errors;
    }
}
