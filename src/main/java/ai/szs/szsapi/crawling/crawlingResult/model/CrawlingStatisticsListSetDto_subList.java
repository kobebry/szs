package ai.szs.szsapi.crawling.crawlingResult.model;

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
public class CrawlingStatisticsListSetDto_subList {

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "1")
    public long pIdx;

    @JsonProperty("field")
    @ApiModelProperty(value="field")
    public String field;

    @JsonProperty("overlapCompany")
    @ApiModelProperty(value="overlapCompany", example = "N")
    public String overlapCompany;
}
