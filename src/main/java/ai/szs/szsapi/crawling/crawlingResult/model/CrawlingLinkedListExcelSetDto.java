
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
public class CrawlingLinkedListExcelSetDto {

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "122")
    public long pIdx;

    @JsonProperty("field")
    @ApiModelProperty(value="field", example = "")
    public String field;

    @JsonProperty("industry")
    @ApiModelProperty(value="industry", example = "")
    public String industry;

    @JsonProperty("productType")
    @ApiModelProperty(value="productType", example = "전체 : ''/ 생산:'생산기업' / 비생산 : '비생산기업'")
    public String productType;

}
