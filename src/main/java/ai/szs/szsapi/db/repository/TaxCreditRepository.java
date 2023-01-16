package ai.szs.szsapi.db.repository;

import ai.szs.szsapi.db.domain.TaxCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaxCreditRepository extends JpaRepository<TaxCredit, Long> {

    List<TaxCredit> findAllByUserId(@Param("userId") String userId);
}
