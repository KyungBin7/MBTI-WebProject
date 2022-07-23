package Web.MBTIWebProject.repository;

import Web.MBTIWebProject.domain.Member;

import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Long.max;

public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member result = em.createQuery("select m from Member m where m.name= : name", Member.class)
                .setParameter("name", name)
                .getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }

   @Override
    public Optional<Member> update(String name, String res){
        Member result = findByName(name).get();
        em.remove(result);

        String servey[]=res.split("");
        Long tmp;
        for(int i=0;i<servey.length;i++){
            switch (servey[i]){
                case "A":
                    tmp = result.getBall();
                    result.setBall(++tmp);
                    break;
                case "B":
                    tmp = result.getSwim();
                    result.setSwim(++tmp);
                    break;
                case "C":
                    tmp = result.getSnow();
                    result.setSnow(++tmp);
                    break;
                case "D":
                    tmp = result.getRun();
                    result.setRun(++tmp);
                    break;
            }
        }
       save(result);
       return Optional.ofNullable(result);
    }

    public List<Long> rank(String name){
        Member result = findByName(name).get();
        List<Long> resultList = new ArrayList<Long>();

        Long sports;
        Long arts;
        Long music;
        Long hobby;
        Long instrument;

        sports=result.getBall();
        sports=max(sports,result.getSwim());
        sports=max(sports,result.getSnow());
        sports=max(sports,result.getRun());
        resultList.add(sports);

        arts=result.getMusic();
        arts=max(arts,result.getDraw());
        arts=max(arts,result.getValet());
        arts=max(arts,result.getMedia());
        resultList.add(arts);

        music=result.getClasic();
        music=max(music,result.getHip());
        music=max(music,result.getPop());
        music=max(music,result.getTrot());
        resultList.add(music);

        hobby=result.getDiary();
        hobby=max(hobby,result.getTen());
        hobby=max(hobby,result.getCros());
        hobby=max(hobby,result.getCook());
        resultList.add(hobby);

        instrument=result.getSt();
        instrument=max(instrument,result.getWind());
        instrument=max(instrument,result.getPer());
        instrument=max(instrument,result.getEl());
        resultList.add(instrument);

        return resultList;
    }
}
