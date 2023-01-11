package ai.szs.szsapi.crawling.crawlingResult.model;

public interface CrawlingResultItemListGetDto {
    String getItemName();
    String getCompanyName();
    String getProductType();
    String getMatchUrl();
    String getMatchKeyword();
    String getKwdCount();
    String getMatchCount();
}
