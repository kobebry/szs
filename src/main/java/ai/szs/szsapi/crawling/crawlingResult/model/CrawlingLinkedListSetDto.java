
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
public class CrawlingLinkedListSetDto {

    @JsonProperty("draw")
    public int draw;

    @JsonProperty("start")
    public int start;

    @JsonProperty("length")
    public int length;

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "1")
    public long pIdx;

    @JsonProperty("field")
    @ApiModelProperty(value="field", example = "G0100000")
    public String field;

    @JsonProperty("industry")
    @ApiModelProperty(value="industry", example = "G0100000")
    public String industry;

    @JsonProperty("productType")
    @ApiModelProperty(value="productType", example = "전체 : ''/ 생산:'생산기업' / 비생산 : '비생산기업'")
    public String productType;

}
