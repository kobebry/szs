package ai.szs.szsapi.crawling.crawlingReport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrawlingReportSetDto {

    @JsonProperty("draw")
    public int draw;

    @JsonProperty("start")
    public int start;

    @JsonProperty("length")
    public int length;

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "14")
    public long pIdx;

    @JsonProperty("field")
    @ApiModelProperty(value="field")
    public String field;

    @JsonProperty("industry")
    @ApiModelProperty(value="industry")
    public String industry;

    @JsonProperty("itemName")
    @ApiModelProperty(value="productType")
    public String itemName;
}
