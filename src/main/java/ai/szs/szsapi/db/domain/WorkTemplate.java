package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_work_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="templateIdx")
    @JsonProperty("templateIdx")
    private Long templateIdx;

    @Column(name="awsTemplateKey")
    private String awsTemplateKey;

    @Column(name="templateCode")
    private String templateCode;

    @Column(name="templateName")
    private String templateName;

    @Column(name="useYn")
    private String useYn;

    @Column(name="regDate", insertable=false)
    private String regDate;

    @Column(name="templateCategory")
    private String templateCategory;

    @Column(name="jobType")
    @JsonProperty("jobType")
    private String jobType;
}
