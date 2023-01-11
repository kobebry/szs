package ai.szs.szsapi.crawling.crawlingList.model;


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
public class FileCompanyListSetDto {

    @JsonProperty("draw")
    public int draw;

    @JsonProperty("start")
    public int start;

    @JsonProperty("length")
    public int length;

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX")
    public long pIdx;
}
