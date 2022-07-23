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
        em.remove(result);
        String servey[]=res.split(" ");
        Long tmp = result.getSeq();
        result.setSeq(++tmp);
        for(int i=0;i<servey.length;i++){
            String symbol[] = servey[i].split("");
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
                    case "E":
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
                    case "E":
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
                    case "E":
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
                    case "E":
                        break;
                }
            }
            else if(symbol[0].equals("5")){
                switch (symbol[1]){
                    case "A":
                        tmp = result.getSt();
                        result.setSt(++tmp);
                        break;
                    case "B":
                        tmp = result.getWind();
                        result.setWind(++tmp);
                        break;
                    case "C":
                        tmp = result.getPer();
                        result.setPer(++tmp);
                        break;
                    case "D":
                        tmp = result.getEl();
                        result.setEl(++tmp);
                        break;
                    case "E":
                        break;
                }
            }
        }
       save(result);
       return Optional.ofNullable(result);
    }

    public Result rank(String name){
        Member result = findByName(name).get();
        Result res = new Result();

        res.setName(name);
        res.setSequence(result.getSeq());

        HashMap<Long, String> resultMap = new HashMap<Long, String>();

        HashMap<Long, String> sports = new HashMap<Long, String>();
        HashMap<Long, String> arts = new HashMap<Long, String>();
        HashMap<Long, String> music = new HashMap<Long, String>();
        HashMap<Long, String> hobby = new HashMap<Long, String>();
        HashMap<Long, String> instrument = new HashMap<Long, String>();

        sports.put(result.getBall(), "구기");
        sports.put(result.getSwim(), "수영");
        sports.put(result.getSnow(), "스키, 보드");
        sports.put(result.getRun(), "자전거, 달리기");
        Long maxKey = Collections.max(sports.keySet());
        res.setRes1Long(maxKey);
        res.setRes1(sports.get(maxKey));

        arts.put(result.getMusic(), "음악");
        arts.put(result.getDraw(), "조형물(그림)");
        arts.put(result.getValet(), "행위(발레)");
        arts.put(result.getMedia(), "미디어");
        maxKey = Collections.max(arts.keySet());
        res.setRes2Long(maxKey);
        res.setRes2(arts.get(maxKey));

        music.put(result.getClasic(), "클래식");
        music.put(result.getHip(), "힙합");
        music.put(result.getPop(), "발라드, 팝송");
        music.put(result.getTrot(), "트로트");
        maxKey = Collections.max(music.keySet());
        res.setRes3Long(maxKey);
        res.setRes3(music.get(maxKey));

        hobby.put(result.getDiary(), "다이어리 꾸미기");
        hobby.put(result.getTen(), "보석 십자수");
        hobby.put(result.getCros(), "뜨개질");
        hobby.put(result.getCook(), "요리");
        maxKey = Collections.max(hobby.keySet());
        res.setRes4Long(maxKey);
        res.setRes4(hobby.get(maxKey));

        instrument.put(result.getSt(), "현악기");
        instrument.put(result.getWind(), "관악기");
        instrument.put(result.getPer(), "타악기");
        instrument.put(result.getEl(), "전자 악기");
        maxKey = Collections.max(instrument.keySet());
        res.setRes5Long(maxKey);
        res.setRes5(instrument.get(maxKey));

        return res;
    }
}
