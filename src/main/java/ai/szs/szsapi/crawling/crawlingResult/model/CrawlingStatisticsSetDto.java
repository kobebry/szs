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
public class CrawlingStatisticsSetDto {

    @JsonProperty("pIdx")
    @ApiModelProperty(value="t_file IDX", example = "2")
    public long pIdx;

    @JsonProperty("targetType")
    @ApiModelProperty(value="targetType", example = "G")
    public String targetType;

    @JsonProperty("overlapCompany")
    @ApiModelProperty(value="overlapCompany", example = "N")
    public String overlapCompany;

    @JsonProperty("sch_industryList")
    @ApiModelProperty(value="sch_industryList")
    public List<String> sch_industryList;

    @JsonProperty("sch_fieldList")
    @ApiModelProperty(value="sch_fieldList")
    public List<String> sch_fieldList;
}
