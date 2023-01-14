package ai.szs.szsapi.db.repository;

import ai.szs.szsapi.db.domain.Salary;
import ai.szs.szsapi.db.domain.SalaryList;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {


    @Query(value = "select 소득내역,총지급액,업무시작일,기업명,이름,지급일,업무종료일,주민등록번호,소득구분,사업자등록번호 from Salary as s where memberIdx = :memberIdx and year = :year", nativeQuery = true)
    List<SalaryList> findAllByMAndMemberIdx(@Param("memberIdx") long memberIdx, @Param("year") String year);

}
