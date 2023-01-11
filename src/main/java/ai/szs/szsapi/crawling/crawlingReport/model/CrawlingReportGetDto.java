package ai.szs.szsapi.crawling.crawlingReport.model;

public interface CrawlingReportGetDto {
    int getRow();
    String getCompanyName();
    String getMatchUrl();
    String getMatchKeyword();
    String getMatchSource();

    String get분야();
    String get산업();
    String get품목();
}
