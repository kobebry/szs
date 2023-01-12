package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="t_member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberIdx")
    @JsonProperty("memberIdx")
    private Long memberIdx;

    @Column(name="userId")
    @JsonProperty("userId")
    private String userId;

    @Column(name="password")
    @JsonProperty("password")
    private String password;

    @Column(name="name")
    @JsonProperty("name")
    private String name;

    @Column(name="regNo")
    @JsonProperty("regNo")
    private String regNo;

    @Column(name="regDate", updatable = false)
    @JsonProperty("regDate")
    private String regDate;

}
