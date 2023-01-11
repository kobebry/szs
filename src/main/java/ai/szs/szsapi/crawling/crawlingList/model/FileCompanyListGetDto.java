package ai.szs.szsapi.crawling.crawlingList.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileCompanyListGetDto {

    @JsonProperty("fcIdx")
    private Long fcIdx;

    @JsonProperty("companyCountry")
    private String companyCountry;

    @JsonProperty("companyField")
    private String companyField;

    @JsonProperty("분야")
    private String 분야;

    @JsonProperty("산업")
    private String 산업;

    @JsonProperty("품목")
    private String 품목;

    @JsonProperty("GVCCD")
    private String GVCCD;

    @JsonProperty("기업명")
    private String 기업명;

    @JsonProperty("URL")
    private String URL;

    @JsonProperty("소부장")
    private String 소부장;

    @JsonProperty("사업자번호")
    private String 사업자번호;

    @JsonProperty("법인번호")
    private String 법인번호;

    @JsonProperty("기업ID")
    private String 기업ID;

    @JsonProperty("iso")
    private String iso;

    @JsonProperty("matchKeyword")
    private String matchKeyword;

    @JsonProperty("matchUrl")
    private String matchUrl;

    @JsonProperty("matchFileName")
    private String matchFileName;

    @JsonProperty("matchSource")
    private String matchSource;

    @JsonProperty("urlAccuracy")
    private String urlAccuracy;

    @JsonProperty("regDate")
    private String regDate;

    @JsonProperty("fIdx")
    private Long fIdx;

    @JsonProperty("industry")
    private String industry;

    @JsonProperty("seq")
    private String seq;
}
