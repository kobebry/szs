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
@Table(name="t_project_file")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pfIdx")
    @JsonProperty("pfIdx")
    private Long pfIdx;

    @Column(name="pIdx")
    @JsonProperty("pIdx")
    private Long pIdx;

    @Column(name="fIdx")
    @JsonProperty("fIdx")
    private Long fIdx;
}
