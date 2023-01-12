package ai.szs.szsapi.core.signup.model;

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
public class SignUpSetDto {

    @JsonProperty("userId")
    @ApiModelProperty(value="아이디", required = true)
    public String userId;

    @JsonProperty("password")
    @ApiModelProperty(value="패스워드", required = true)
    public String password;

    @JsonProperty("name")
    @ApiModelProperty(value="이름", required = true)
    public String name;

    @JsonProperty("regNo")
    @ApiModelProperty(value="주민등록번호", required = true)
    public String regNo;

}
