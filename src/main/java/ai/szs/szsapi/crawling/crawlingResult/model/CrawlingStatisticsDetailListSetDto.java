
package ai.szs.szsapi.crawling.crawlingResult.model;

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
public class CrawlingStatisticsDetailListSetDto {

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "1")
    public long pIdx;

    @JsonProperty("industry")
    @ApiModelProperty(value="industry", example = "G0101000")
    public String industry;

    @JsonProperty("field")
    @ApiModelProperty(value="field", example = "G0100000")
    public String field;

    @JsonProperty("targetType")
    @ApiModelProperty(value="targetType", example = "G")
    public String targetType;

}
