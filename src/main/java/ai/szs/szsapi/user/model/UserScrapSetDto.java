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
public class UserScrapSetDto {

    @JsonProperty("name")
    @ApiModelProperty(value="이름", required = true, example = "홍길동")
    public String name;

    @JsonProperty("regNo")
    @ApiModelProperty(value="주민등록번호", required = true, example = "860824-1655068")
    public String regNo;

}
