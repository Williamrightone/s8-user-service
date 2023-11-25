package cc.synpulse8.userservice.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "AUTH_GROUP")
@AllArgsConstructor
@NoArgsConstructor
public class AuthGroupEntity implements Serializable {

    @Id
    @Column(name = "AUTH_GROUP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authGroupId;

    @Column(name = "GROUP_NAME", nullable = false)
    private String groupName;

    @Column(name = "GROUP_DESCRIPTION", nullable = false)
    private String groupDescription;

}
