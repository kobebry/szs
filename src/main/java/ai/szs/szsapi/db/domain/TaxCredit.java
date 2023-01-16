package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TaxCredit")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="taxIdx")
    @JsonProperty("taxIdx")
    private Long taxIdx;

    @Column(name="userId")
    @JsonProperty("userId")
    private String userId;

    @Column(name="금액")
    @JsonProperty("금액")
    private String 금액;

    @Column(name="소득구분")
    @JsonProperty("소득구분")
    private String 소득구분;
}
