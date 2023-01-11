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
@Table(name="t_file")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fIdx")
    @JsonProperty("fIdx")
    private Long fIdx;

    @Column(name="fileType")
    @JsonProperty("fileType")
    private String fileType;

    @Column(name="targetType")
    @JsonProperty("targetType")
    private String targetType;

    @Column(name="fileName")
    @JsonProperty("fileName")
    private String fileName;

    @Column(name="fileSize")
    @JsonProperty("fileSize")
    private String fileSize;

    @Column(name="regId")
    @JsonProperty("regId")
    private String regId;

    @Column(name="regDate", insertable=false, updatable = false)
    @JsonProperty("regDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime regDate;

    @Column(name="fileUploadType")
    @JsonProperty("fileUploadType")
    private String fileUploadType;

    @Column(name="remark")
    @JsonProperty("remark")
    private String remark;

    @Column(name="year")
    @JsonProperty("year")
    private String year;

    @Column(name="awsKey")
    @JsonProperty("awsKey")
    private String awsKey;

    @Column(name="uploadStatus", insertable=false)
    @JsonProperty("uploadStatus")
    private String uploadStatus;

    @JsonProperty("targetTypeName")
    @Column(insertable=false, updatable = false)
    private String targetTypeName;

    @JsonProperty("mName")
    @Column(insertable=false, updatable = false)
    private String mName;
}
