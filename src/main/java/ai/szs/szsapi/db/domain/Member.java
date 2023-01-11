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
    @Column(name="mIdx")
    @JsonProperty("mIdx")
    private Long mIdx;

    @Column(name="mId")
    @JsonProperty("mId")
    private String mId;

    @Column(name="email")
    @JsonProperty("email")
    private String email;

    @Column(name="hashed_password")
    @JsonProperty("hashed_password")
    private String hashed_password;

    @Column(name="mName")
    @JsonProperty("mName")
    private String mName;

    @Column(name="memberType")
    @JsonProperty("memberType")
    private String memberType;

    @Column(name="lastLoginDate")
    @JsonProperty("lastLoginDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime lastLoginDate;

    @Column(name="regDate", insertable=false, updatable = false)
    @JsonProperty("regDate")
    private String regDate;

    @Column(name="modDate", insertable=false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modDate;


}
