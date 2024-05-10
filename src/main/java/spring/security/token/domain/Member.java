package spring.security.token.domain;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "login_id", length = 20, unique = true)
    private String loginId;

    @Column(name = "login_password", length = 256)
    private String loginPassword;

    @Enumerated(STRING)
    private Role role;
}
