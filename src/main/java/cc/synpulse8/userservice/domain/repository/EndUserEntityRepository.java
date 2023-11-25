package cc.synpulse8.userservice.domain.repository;

import cc.synpulse8.userservice.domain.model.entity.EndUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndUserEntityRepository extends JpaRepository<EndUserEntity, Long> {

    public Optional<EndUserEntity> findBySid(String sid);

}
