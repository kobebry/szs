package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="MEMBER_AVAILABLE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberAvailable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberAvailableIdx")
    @JsonProperty("memberAvailableIdx")
    private Long memberAvailableIdx;

    @Column(name="name")
    @JsonProperty("name")
    private String name;

    @Column(name="regNo")
    @JsonProperty("regNo")
    private String regNo;

}
