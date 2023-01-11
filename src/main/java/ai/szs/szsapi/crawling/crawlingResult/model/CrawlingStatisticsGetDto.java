package ai.szs.szsapi.crawling.crawlingResult.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public interface CrawlingStatisticsGetDto {

    String getFieldCode();
    String getField();
    String getIndustryCode();
    String getIndustry();
    int getProductCnt();
    int getNotProductCnt();
    int getTotalCnt();
}
