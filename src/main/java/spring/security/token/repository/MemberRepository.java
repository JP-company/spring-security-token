package spring.security.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.token.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
