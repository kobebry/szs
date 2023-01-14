package ai.szs.szsapi.login.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSetDto {

    @JsonProperty("userId")
    @ApiModelProperty(value="아이디", required = true, example = "hong12")
    String userId;

    @JsonProperty("password")
    @ApiModelProperty(value="패스워드", required = true, example = "123456")
    String password;
}
