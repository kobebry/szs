package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_file_company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileCompany {

    @Id
    @Column(name="fcIdx")
    @JsonProperty("fcIdx")
    private Long fcIdx;

    @Column(name="fIdx")
    @JsonProperty("fIdx")
    private Long fIdx;

    @Column(name="country")
    @JsonProperty("country")
    private String country;

    @Column(name="targetType")
    @JsonProperty("targetType")
    private String targetType;

    @Column(name="분야")
    @JsonProperty("분야")
    private String 분야;

    @Column(name="산업")
    @JsonProperty("산업")
    private String 산업;

    @Column(name="품목")
    @JsonProperty("품목")
    private String 품목;

    @Column(name="GVCCD")
    @JsonProperty("GVCCD")
    private String GVCCD;

    @Column(name="기업명")
    @JsonProperty("기업명")
    private String 기업명;

    @Column(name="URL")
    @JsonProperty("URL")
    private String URL;

    @Column(name="소부장")
    @JsonProperty("소부장")
    private String 소부장;

    @Column(name="사업자번호")
    @JsonProperty("사업자번호")
    private String 사업자번호;

    @Column(name="법인번호")
    @JsonProperty("법인번호")
    private String 법인번호;

    @Column(name="기업ID")
    @JsonProperty("기업ID")
    private String 기업ID;

    @Column(name="iso")
    @JsonProperty("iso")
    private String iso;

    @Column(name="urlAccuracy")
    @JsonProperty("urlAccuracy")
    private String urlAccuracy;

    @Column(name="companyCode")
    @JsonProperty("companyCode")
    private String companyCode;

    @JsonProperty("industry")
    private String industry;

    @JsonProperty("seq")
    private String seq;

    @JsonProperty("field")
    private String field;

}
