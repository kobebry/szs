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
@Table(name="t_kwd")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kIdx")
    @JsonProperty("kIdx")
    private long kIdx;

    @Column(name="kfIdx")
    @JsonProperty("kfIdx")
    private String kfIdx;

    @Column(name="kwdType")
    @JsonProperty("kwdType")
    private String kwdType;

    @Column(name="kwdTypeDetail")
    @JsonProperty("kwdTypeDetail")
    private String kwdTypeDetail;

    @Column(name="GVCCD")
    @JsonProperty("GVCCD")
    private String GVCCD;

    @Column(name="품목")
    @JsonProperty("품목")
    private String 품목;

    @Column(name="kwdOrigin")
    @JsonProperty("kwdOrigin")
    private String kwdOrigin;

    @Column(name="keyword")
    @JsonProperty("keyword")
    private String keyword;

    @Column(name="statusRequest")
    @JsonProperty("statusRequest")
    private String statusRequest;

    @Column(name="statusChecked")
    @JsonProperty("statusChecked")
    private String statusChecked;

    @Column(name="sCommon")
    @JsonProperty("sCommon")
    private String sCommon;

    @Column(name="enKwd")
    @JsonProperty("enKwd")
    private String enKwd;

    @Column(name="sAdd")
    @JsonProperty("sAdd")
    private String sAdd;

    @Column(name="sHandSearch")
    @JsonProperty("sHandSearch")
    private String sHandSearch;

    @Column(name="sTransIct")
    @JsonProperty("sTransIct")
    private String sTransIct;

    @Column(name="sTransScience")
    @JsonProperty("sTransScience")
    private String sTransScience;

    @Column(name="sSubstitute")
    @JsonProperty("sSubstitute")
    private String sSubstitute;

    @Column(name="sTransKo")
    @JsonProperty("sTransKo")
    private String sTransKo;

    @Column(name="sTransEn")
    @JsonProperty("sTransEn")
    private String sTransEn;

    @Column(name="No")
    @JsonProperty("No")
    private String No;

    @Column(name="대상코드")
    @JsonProperty("대상코드")
    private String 대상코드;

    @Column(name="대상")
    @JsonProperty("대상")
    private String 대상;

    @Column(name="분야코드")
    @JsonProperty("분야코드")
    private String 분야코드;

    @Column(name="분야")
    @JsonProperty("분야")
    private String 분야;

    @Column(name="산업코드")
    @JsonProperty("산업코드")
    private String 산업코드;

    @Column(name="산업")
    @JsonProperty("산업")
    private String 산업;

    @Column(name="품목코드")
    @JsonProperty("품목코드")
    private String 품목코드;

    @Column(name="품목개요")
    @JsonProperty("품목개요")
    private String 품목개요;

    @Column(name="regDate", insertable=false, updatable = false)
    @JsonProperty("regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name="modDate", insertable=false)
    @JsonProperty("modDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modDate;

    @Column(name="saveDate", insertable=false, updatable = false)
    @JsonProperty("saveDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime saveDate;

    @Column(name="industry", insertable=false, updatable = false)
    private String industry;
    @Column(name="seq", insertable=false, updatable = false)
    private String seq;
    @Column(name="field", insertable=false, updatable = false)
    private String field;

    @Column(name="row", insertable=false, updatable = false)
    private int row;

}
