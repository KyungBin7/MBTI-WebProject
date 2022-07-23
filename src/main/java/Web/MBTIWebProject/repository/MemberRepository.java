package Web.MBTIWebProject.repository;

import Web.MBTIWebProject.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    Optional<Member> update(String name, String res);
    public List<Long> rank(String name);
}
