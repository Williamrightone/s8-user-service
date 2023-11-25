package cc.synpulse8.userservice.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "GROUP_PERMISSION_MP")
@AllArgsConstructor
@NoArgsConstructor
public class GroupPermissionMpEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GROUP_PERMISSION_MP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupPermissionMpId;

    @Column(name = "AUTH_GROUP_ID", nullable = false)
    private Long authGroupId;

    @Column(name = "PERMISSION_ID", nullable = false)
    private Long permissionId;
}
