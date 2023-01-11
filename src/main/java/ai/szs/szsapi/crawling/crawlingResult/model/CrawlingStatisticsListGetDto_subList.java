package ai.szs.szsapi.crawling.crawlingResult.model;

public interface CrawlingStatisticsListGetDto_subList {

    String getField();
    String getFieldCode();

    String getIndustry();
    String getIndustryCode();

    String getItemName();

    int getProductCnt();
    int getNotProductCnt();
    int getTotalCnt();
}
