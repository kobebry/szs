package ai.szs.szsapi.db.repository;

import ai.szs.szsapi.db.domain.TaxAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TaxAmountRepository extends JpaRepository<TaxAmount, Long> {

    Optional<TaxAmount> findByMemberIdx(@Param("memberIdx") long memberIdx);

}
