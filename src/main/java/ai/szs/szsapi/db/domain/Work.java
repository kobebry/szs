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
@Table(name="t_work")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wIdx")
    @JsonProperty("wIdx")
    private Long wIdx;

    @Column(name="wName")
    @JsonProperty("wName")
    private String wName;

    @Column(name="sourceLink1")
    @JsonProperty("sourceLink1")
    private String sourceLink1;

    @Column(name="sourceLink2")
    @JsonProperty("sourceLink2")
    private String sourceLink2;

    @Column(name="wStatus")
    @JsonProperty("wStatus")
    private String wStatus;

    @Column(name="regId")
    @JsonProperty("regId")
    private String regId;


    @JsonProperty("regDate")
    @Column(name="regDate", insertable=false, updatable = false)
    private String regDate;

    @Column(name="modId")
    @JsonProperty("modId")
    private String modId;

    @Column(name="modDate" , insertable=false)
    @JsonProperty("modDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modDate;

    @Column(name="wType")
    @JsonProperty("wType")
    private String wType;

    @Column(name="pIdx")
    @JsonProperty("pIdx")
    private int pIdx;

    @Column(name="sourceKey1")
    @JsonProperty("sourceKey1")
    private String sourceKey1;

    @Column(name="sourceKey2")
    @JsonProperty("sourceKey2")
    private String sourceKey2;

    @Column(name="workSeq")
    @JsonProperty("workSeq")
    private int workSeq;

}
