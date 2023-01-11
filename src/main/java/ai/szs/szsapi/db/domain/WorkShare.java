package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_work_share")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shareIdx")
    @JsonProperty("shareIdx")
    private Long shareIdx;

    @Column(name="wIdx")
    @JsonProperty("wIdx")
    private Long wIdx;

    @Column(name="shareLink")
    private String shareLink;

    @Column(name="shareType")
    private String shareType;

    @Column(name="sharePassword")
    private String sharePassword;

    @Column(name="shareExpireDate")
    private String shareExpireDate;

    @Column(name="shareRole")
    private String shareRole;

    @Column(name="sheetNum")
    private int sheetNum;

    @Column(name="secureYn")
    private String secureYn;

    @Column(name="regId")
    private Long regId;

    @Column(name="regDate", insertable=false)
    private String regDate;

    @Column(name="modId")
    private Long modId;

    @Column(name="modDate")
    private String modDate;

    @Column(name="sheetName")
    private String sheetName;

}
