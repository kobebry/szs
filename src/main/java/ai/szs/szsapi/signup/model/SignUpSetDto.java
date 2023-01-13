package ai.szs.szsapi.signup.model;

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
    @ApiModelProperty(value="아이디", required = true, example = "hong12")
    public String userId;

    @JsonProperty("password")
    @ApiModelProperty(value="패스워드", required = true, example = "123456")
    public String password;

    @JsonProperty("name")
    @ApiModelProperty(value="이름", required = true, example = "홍길동")
    public String name;

    @JsonProperty("regNo")
    @ApiModelProperty(value="주민등록번호", required = true, example = "860824-1655068")
    public String regNo;

}
