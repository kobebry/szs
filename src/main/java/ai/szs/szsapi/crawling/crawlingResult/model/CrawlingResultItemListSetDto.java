
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
public class CrawlingResultItemListSetDto {

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "2")
    public long pIdx;

    @JsonProperty("gvccd")
    @ApiModelProperty(value="gvccd", example = "레이저 마킹 시스템")
    public String gvccd;

}
