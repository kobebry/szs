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
public class CrawlingStatisticsListSetDto {

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "1")
    public long pIdx;

    @JsonProperty("overlapCompany")
    @ApiModelProperty(value="overlapCompany", example = "N")
    public String overlapCompany;

    @JsonProperty("sch_industryList")
    @ApiModelProperty(value="sch_industryList")
    public List<String> sch_industryList;


}
