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
@Table(name="t_project_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="phIdx")
    @JsonProperty("phIdx")
    private Long phIdx;

    @Column(name="pIdx")
    @JsonProperty("pIdx")
    private Long pIdx;

    @Column(name="apiType")
    @JsonProperty("apiType")
    private String apiType;

    @Column(name="projectType")
    @JsonProperty("projectType")
    private String projectType;

    @Column(name="startDate")
    @JsonProperty("startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime startDate;

    @Column(name="endDate")
    @JsonProperty("endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime endDate;

    @Column(name="totalCount")
    @JsonProperty("totalCount")
    private String totalCount;


    @Column(name="expectDate")
    @JsonProperty("expectDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime expectDate;

    @Column(name="spendTime")
    @JsonProperty("spendTime")
    private String spendTime;

    @Column(name="historyStatus")
    @JsonProperty("historyStatus")
    private String historyStatus;

    @Column(name="regId")
    @JsonProperty("regId")
    private String regId;

    @JsonProperty("projectName")
    private String projectName;

    @JsonProperty("mName")
    private String mName;

    @JsonProperty("apiTypeName")
    private String apiTypeName;
}
