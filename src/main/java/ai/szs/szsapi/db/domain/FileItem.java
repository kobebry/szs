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
public class FileItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fiIdx")
    @JsonProperty("fiIdx")
    private Long fiIdx;

    @Column(name="fIdx")
    @JsonProperty("fIdx")
    private Long fIdx;

    @Column(name="targetType")
    @JsonProperty("targetType")
    private String targetType;

    @Column(name="연도")
    @JsonProperty("연도")
    private String 연도;

    @Column(name="수출입")
    @JsonProperty("수출입")
    private String 수출입;

    @Column(name="HS_CD")
    @JsonProperty("HS_CD")
    private String HS_CD;

    @Column(name="거래품명")
    @JsonProperty("거래품명")
    private String 거래품명;

    @Column(name="기존표준품명")
    @JsonProperty("기존표준품명")
    private String 기존표준품명;

    @Column(name="matchKeyword")
    @JsonProperty("matchKeyword")
    private String matchKeyword;

    @Column(name="regDate", insertable=false)
    @JsonProperty("regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name="row", insertable=false, updatable = false)
    private int row;
}
