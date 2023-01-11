package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_project")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pIdx")
    @JsonProperty("pIdx")
    private Long pIdx;

    @Column(name="projectName")
    @JsonProperty("projectName")
    private String projectName;

    @Column(name="startFirstDate")
    @JsonProperty("startFirstDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime startFirstDate;

    @Column(name="endLastDate")
    @JsonProperty("endLastDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime endLastDate;

    @Column(name="spendFinalTime")
    @JsonProperty("spendFinalTime")
    private String spendFinalTime;

    @Column(name="requestStatus")
    @JsonProperty("requestStatus")
    private String requestStatus;

    @Column(name="projectStatus")
    @JsonProperty("projectStatus")
    private String projectStatus;

    @Column(name="regId")
    @JsonProperty("regId")
    private String regId;

    @Column(name="regDate", insertable=false)
    @JsonProperty("regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name="modDate", insertable=false)
    @JsonProperty("modDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modDate;

    @Column(name="targetType")
    @JsonProperty("targetType")
    private String targetType;

    @Column(name="projectType")
    @JsonProperty("projectType")
    private String projectType;

    @Column(name="productType")
    @JsonProperty("productType")
    private String productType;

    @Column(name="HSCD")
    @JsonProperty("HSCD")
    private String HSCD;

    @Column(name="transStatus")
    @JsonProperty("transStatus")
    private String transStatus;

    @JsonProperty("targetTypeName")
    @Column(insertable=false, updatable = false)
    private String targetTypeName;

    @JsonProperty("projectTypeName")
    @Column(insertable=false, updatable = false)
    private String projectTypeName;

    @JsonProperty("mName")
    @Column(insertable=false, updatable = false)
    private String mName;

}
