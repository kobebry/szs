package ai.szs.szsapi.crawling.crawlingResult.model;

public interface CrawlingStatisticsDetailListGetDto {

    String getItemName();
    String getIndustry();
    String getField();
    String getIndustryCode();
    String getFieldCode();
    String get품목코드();
    int getProductCnt();
    int getNotProductCnt();
    int getTotalCnt();
    String getGvccd();

}
