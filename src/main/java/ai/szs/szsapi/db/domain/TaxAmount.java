package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TaxAmount")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="taxAmountIdx")
    @JsonProperty("taxAmountIdx")
    private Long taxAmountIdx;

    @Column(name="userId")
    @JsonProperty("userId")
    private String userId;

    @Column(name="산출세액")
    @JsonProperty("산출세액")
    private String 산출세액;

}
