package ai.szs.szsapi.db.repository;

import ai.szs.szsapi.db.domain.Member;
import ai.szs.szsapi.db.domain.MemberAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberAvailableRepository extends JpaRepository<MemberAvailable, Long> {

}
