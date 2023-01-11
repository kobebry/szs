package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_kwd_translation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeywordTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ktIdx")
    @JsonProperty("ktIdx")
    private Long ktIdx;

    @Column(name="keyword")
    @JsonProperty("keyword")
    private String keyword;

    @Column(name="resultKeyword")
    @JsonProperty("resultKeyword")
    private String resultKeyword;

    @Column(name="isoSource")
    @JsonProperty("isoSource")
    private String isoSource;

    @Column(name="isoTarget")
    @JsonProperty("isoTarget")
    private String isoTarget;

    @Column(name="transStatus")
    @JsonProperty("transStatus")
    private String transStatus;

    @Column(name="addStatus")
    @JsonProperty("addStatus")
    private String addStatus;

    @Column(name="transType")
    @JsonProperty("transType")
    private String transType;

    @Column(name="품목")
    @JsonProperty("품목")
    private String 품목;

    @Column(name="regDate", insertable=false)
    @JsonProperty("regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name="modDate", insertable=false)
    @JsonProperty("modDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modDate;

    private String industry;

    private String field;

    private String 분야;

    private String 산업;


}
