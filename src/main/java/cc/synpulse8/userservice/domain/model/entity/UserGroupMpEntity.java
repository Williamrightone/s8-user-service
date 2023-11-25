package cc.synpulse8.userservice.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "USER_GROUP_MP")
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupMpEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_GROUP_MP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGroupMpId;

    @Column(name = "sid", nullable = false)
    private String sid;

    @Column(name = "AUTH_GROUP_ID", nullable = false)
    private Long authGroupId;

}
