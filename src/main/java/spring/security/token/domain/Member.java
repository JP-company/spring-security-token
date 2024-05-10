package spring.security.token.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "login_id", length = 20, unique = true)
    private String loginId;

    @Column(name = "login_password", length = 256)
    private String loginPassword;

    @Enumerated(STRING)
    private Role role;

    private Member(String loginId, String loginPassword) {
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.role = Role.MEMBER;

        this.validate();
    }

    public static Member create(String loginId, String loginPassword) {
        return new Member(loginId, loginPassword);
    }

    public void setAdminRole() {
        this.role = Role.ADMIN;
    }

    private void validate() {
        // TODO - loginId, loginPassword 검증
    }
}
