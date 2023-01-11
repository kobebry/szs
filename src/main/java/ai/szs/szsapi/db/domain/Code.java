package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_code")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tcIdx")
    @JsonProperty("tcIdx")
    private Long tcIdx;

    @Column(name="codeId")
    @JsonProperty("codeId")
    private String codeId;

    @Column(name="code")
    @JsonProperty("code")
    private String code;

    @Column(name="codeName")
    @JsonProperty("codeName")
    private String codeName;

    @Column(name="ref1")
    @JsonProperty("ref1")
    private String ref1;

    @Column(name="ref2")
    @JsonProperty("ref2")
    private String ref2;

    @Column(name="ref3")
    @JsonProperty("ref3")
    private String ref3;

    @Column(name="showYn")
    @JsonProperty("showYn")
    private String showYn;

    @Column(name="seq")
    @JsonProperty("seq")
    private int seq;
}
