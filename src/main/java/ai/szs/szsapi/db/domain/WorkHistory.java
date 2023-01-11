package ai.szs.szsapi.db.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_work_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="whIdx")
    private Long whIdx;

    @Column(name="wIdx")
    private Long wIdx;

    @Column(name="requestCnt")
    private int requestCnt;

    @Column(name="successCnt")
    private int successCnt;

    @Column(name="failCnt")
    private String failCnt;

    @Column(name="sendTime")
    private String sendTime;

    @Column(name="regId")
    private String regId;

    @Column(name="regDate", insertable=false)
    private String regDate;

    @Column(name="sourceKey1")
    private String sourceKey1;

    @Column(name="sourceKey2")
    private String sourceKey2;

}
