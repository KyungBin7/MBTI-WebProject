package Web.MBTIWebProject.service;

import Web.MBTIWebProject.domain.Member;
import Web.MBTIWebProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        /*//같은 이름이 있는 중복 회원 X

        memberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalAccessException("이미 존재하는 회원입니다.");
        });*/
        memberRepository.save(member);
        return member.getId();
    }
    public Long update(Member member, String res){
        /*//같은 이름이 있는 중복 회원 X

        memberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalAccessException("이미 존재하는 회원입니다.");
        });*/
        memberRepository.update(member.getName(), res);
        return member.getId();
    }

    public Long rank(Member member){
        HashMap<Long, String> result = new HashMap<Long, String>();
        result = memberRepository.rank(member.getName());
        for (Map.Entry<Long, String> entrySet : result.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById((memberId));
    }
}
