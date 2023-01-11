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
@Table(name="t_file_trade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ftIdx")
    @JsonProperty("ftIdx")
    private Long ftIdx;

    @Column(name="fIdx")
    @JsonProperty("fIdx")
    private Long fIdx;

    @Column(name="tradeType")
    @JsonProperty("tradeType")
    private String tradeType;

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

    @Column(name="HS_CD")
    @JsonProperty("HS_CD")
    private String HS_CD;

    @Column(name="regDate", insertable=false)
    @JsonProperty("regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name="row", insertable=false, updatable = false)
    private int row;

    @Column(name="field", insertable=false, updatable = false)
    private String field;

    @Column(name="industry", insertable=false, updatable = false)
    private String industry;

    @Column(name="targetTypeName", insertable=false, updatable = false)
    private String targetTypeName;
}
