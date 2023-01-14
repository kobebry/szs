package ai.szs.szsapi.user.model;

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
public class UserRefundGetDto {

    @JsonProperty("이름")
    public String 이름;

    @JsonProperty("결정세액")
    public String 결정세액;

    @JsonProperty("퇴직연금세액공제")
    public String 퇴직연금세액공제;

}
