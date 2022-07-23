package Web.MBTIWebProject.repository;

import Web.MBTIWebProject.domain.Member;
import Web.MBTIWebProject.domain.Result;

import javax.persistence.EntityManager;
import java.util.*;

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

        String servey[]=res.split(" ");
        Long tmp;
        for(int i=0;i<servey.length;i++){
            String symbol[] = servey[i].split("");
            System.out.println("symbol0 = " + symbol[0]);
            System.out.println("symbol1 = " + symbol[1]);
            if(symbol[0].equals("1")){
                switch (symbol[1]){
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
            else if(symbol[0].equals("2")){
                switch (symbol[1]){
                    case "A":
                        tmp = result.getMusic();
                        result.setMusic(++tmp);
                        break;
                    case "B":
                        tmp = result.getDraw();
                        result.setDraw(++tmp);
                        break;
                    case "C":
                        tmp = result.getValet();
                        result.setValet(++tmp);
                        break;
                    case "D":
                        tmp = result.getMedia();
                        result.setMedia(++tmp);
                        break;
                }
            }
            else if(symbol[0].equals("3")){
                switch (symbol[1]){
                    case "A":
                        tmp = result.getClasic();
                        result.setClasic(++tmp);
                        break;
                    case "B":
                        tmp = result.getHip();
                        result.setHip(++tmp);
                        break;
                    case "C":
                        tmp = result.getPop();
                        result.setPop(++tmp);
                        break;
                    case "D":
                        tmp = result.getTrot();
                        result.setTrot(++tmp);
                        break;
                }
            }
            else if(symbol[0].equals("4")){
                switch (symbol[1]){
                    case "A":
                        tmp = result.getDiary();
                        result.setDiary(++tmp);
                        break;
                    case "B":
                        tmp = result.getTen();
                        result.setTen(++tmp);
                        break;
                    case "C":
                        tmp = result.getCros();
                        result.setCros(++tmp);
                        break;
                    case "D":
                        tmp = result.getCook();
                        result.setCook(++tmp);
                        break;
                }
            }
            else if(symbol[0].equals("5")){
                switch (symbol[1]){
                    case "A":
                        tmp = result.getSt();
                        result.setBall(++tmp);
                        break;
                    case "B":
                        tmp = result.getWind();
                        result.setSwim(++tmp);
                        break;
                    case "C":
                        tmp = result.getPer();
                        result.setSnow(++tmp);
                        break;
                    case "D":
                        tmp = result.getEl();
                        result.setRun(++tmp);
                        break;
                }
            }
        }
       em.remove(result);
       save(result);
       return Optional.ofNullable(result);
    }

    public Result rank(String name){
        Member result = findByName(name).get();
        Result res = new Result();
        HashMap<Long, String> resultMap = new HashMap<Long, String>();

        HashMap<Long, String> sports = new HashMap<Long, String>();
        HashMap<Long, String> arts = new HashMap<Long, String>();
        HashMap<Long, String> music = new HashMap<Long, String>();
        HashMap<Long, String> hobby = new HashMap<Long, String>();
        HashMap<Long, String> instrument = new HashMap<Long, String>();

        sports.put(result.getBall(), "ball");
        sports.put(result.getSwim(), "swim");
        sports.put(result.getSnow(), "snow");
        sports.put(result.getRun(), "run");
        Long maxKey = Collections.max(sports.keySet());
        res.setRes1Long(maxKey);
        res.setRes1(sports.get(maxKey));

        arts.put(result.getMusic(), "music");
        arts.put(result.getDraw(), "draw");
        arts.put(result.getValet(), "valet");
        arts.put(result.getMedia(), "media");
        maxKey = Collections.max(arts.keySet());
        res.setRes2Long(maxKey);
        res.setRes2(arts.get(maxKey));

        music.put(result.getClasic(), "clasic");
        music.put(result.getHip(), "hip");
        music.put(result.getPop(), "pop");
        music.put(result.getTrot(), "trot");
        maxKey = Collections.max(music.keySet());
        res.setRes3Long(maxKey);
        res.setRes3(music.get(maxKey));

        hobby.put(result.getDiary(), "diary");
        hobby.put(result.getTen(), "ten");
        hobby.put(result.getCros(), "cros");
        hobby.put(result.getCook(), "cook");
        maxKey = Collections.max(hobby.keySet());
        res.setRes4Long(maxKey);
        res.setRes4(hobby.get(maxKey));

        instrument.put(result.getSt(), "string");
        instrument.put(result.getWind(), "wind");
        instrument.put(result.getPer(), "per");
        instrument.put(result.getEl(), "elect");
        maxKey = Collections.max(instrument.keySet());
        res.setRes5Long(maxKey);
        res.setRes5(instrument.get(maxKey));

        return res;
    }
}
