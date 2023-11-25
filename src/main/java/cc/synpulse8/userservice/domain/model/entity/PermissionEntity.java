package cc.synpulse8.userservice.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "PERMISSION")
@AllArgsConstructor
@NoArgsConstructor
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PERMISSION_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(name = "PERMISSION_NAME", nullable = false)
    private String permissionName;

    @Column(name = "PERMISSION_DESCRIPTION", nullable = false)
    private String permissionDescription;

}
