package ai.szs.szsapi.db.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Salary")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="salaryIdx")
    @JsonProperty("salaryIdx")
    private Long salaryIdx;

    @Column(name="memberIdx")
    @JsonProperty("memberIdx")
    private Long memberIdx;

    @Column(name="소득내역")
    @JsonProperty("소득내역")
    private String 소득내역;

    @Column(name="총지급액")
    @JsonProperty("총지급액")
    private String 총지급액;

    @Column(name="업무시작일")
    @JsonProperty("업무시작일")
    private String 업무시작일;

    @Column(name="기업명")
    @JsonProperty("기업명")
    private String 기업명;

    @Column(name="이름")
    @JsonProperty("이름")
    private String 이름;

    @Column(name="지급일")
    @JsonProperty("지급일")
    private String 지급일;

    @Column(name="업무종료일")
    @JsonProperty("업무종료일")
    private String 업무종료일;

    @Column(name="주민등록번호")
    @JsonProperty("주민등록번호")
    private String 주민등록번호;

    @Column(name="소득구분")
    @JsonProperty("소득구분")
    private String 소득구분;

    @Column(name="사업자등록번호")
    @JsonProperty("사업자등록번호")
    private String 사업자등록번호;

    @Column(name="year")
    @JsonProperty("year")
    private String year;

}
