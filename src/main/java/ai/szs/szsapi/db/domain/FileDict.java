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
public class FileDict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fdIdx")
    @JsonProperty("fdIdx")
    private Long fdIdx;

    @Column(name="fIdx")
    @JsonProperty("fIdx")
    private Long fIdx;

    @Column(name="dictField")
    @JsonProperty("dictField")
    private String dictField;

    @Column(name="분야")
    @JsonProperty("분야")
    private String 분야;

    @Column(name="산업")
    @JsonProperty("산업")
    private String 산업;

    @Column(name="소부장")
    @JsonProperty("소부장")
    private String 소부장;

    @Column(name="품목명")
    @JsonProperty("품목명")
    private String 품목명;

    @Column(name="품목개요")
    @JsonProperty("품목개요")
    private String 품목개요;

    @Column(name="GVCCD")
    @JsonProperty("GVCCD")
    private String GVCCD;

    @Column(name="검색어")
    @JsonProperty("검색어")
    private String 검색어;

}
