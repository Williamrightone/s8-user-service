package cc.synpulse8.userservice.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "END_USER")
public class EndUserEntity implements Serializable {

    private static final long serialVersionUID = 6084452811440424431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(unique = true, name = "SID", nullable = false)
    private String sid;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "PASSWD", nullable = false)
    private String passwd;


}
