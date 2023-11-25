package cc.synpulse8.userservice.domain.repository;

import cc.synpulse8.userservice.domain.model.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    @Query(value= "select distinct permission_name from permission p " +
            "left join group_permission_mp gpm " +
            "on p.permission_id = gpm.permission_id " +
            "left join auth_group ag " +
            "on ag.auth_group_id = gpm.auth_group_id " +
            "left join user_group_mp ugm " +
            "on ugm.auth_group_id = ag.auth_group_id " +
            "where ugm.sid = ?1" , nativeQuery = true)
    List<String> findPermissionBySid(String sid);

}
