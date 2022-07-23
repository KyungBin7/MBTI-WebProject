package Web.MBTIWebProject.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long seq=0L;

    private Long ball=0L;
    private Long swim=0L;
    private Long snow=0L;
    private Long run=0L;

    private Long music=0L;
    private Long draw=0L;
    private Long valet=0L;
    private Long media=0L;

    private Long clasic=0L;
    private Long hip=0L;
    private Long pop=0L;
    private Long trot=0L;

    private Long diary=0L;
    private Long ten=0L;
    private Long cros=0L;
    private Long cook=0L;

    private Long st=0L;
    private Long wind=0L;
    private Long per=0L;
    private Long el=0L;








    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getBall() {
        return ball;
    }

    public void setBall(Long ball) {
        this.ball = ball;
    }

    public Long getSwim() {
        return swim;
    }

    public void setSwim(Long swim) {
        this.swim = swim;
    }

    public Long getSnow() {
        return snow;
    }

    public void setSnow(Long snow) {
        this.snow = snow;
    }

    public Long getRun() {
        return run;
    }

    public void setRun(Long run) {
        this.run = run;
    }

    public Long getMusic() {
        return music;
    }

    public void setMusic(Long music) {
        this.music = music;
    }

    public Long getDraw() {
        return draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getValet() {
        return valet;
    }

    public void setValet(Long valet) {
        this.valet = valet;
    }

    public Long getMedia() {
        return media;
    }

    public void setMedia(Long media) {
        this.media = media;
    }

    public Long getClasic() {
        return clasic;
    }

    public void setClasic(Long clasic) {
        this.clasic = clasic;
    }

    public Long getHip() {
        return hip;
    }

    public void setHip(Long hip) {
        this.hip = hip;
    }

    public Long getPop() {
        return pop;
    }

    public void setPop(Long pop) {
        this.pop = pop;
    }

    public Long getTrot() {
        return trot;
    }

    public void setTrot(Long trot) {
        this.trot = trot;
    }

    public Long getDiary() {
        return diary;
    }

    public void setDiary(Long diary) {
        this.diary = diary;
    }

    public Long getTen() {
        return ten;
    }

    public void setTen(Long ten) {
        this.ten = ten;
    }

    public Long getCros() {
        return cros;
    }

    public void setCros(Long cross) {
        this.cros = cross;
    }

    public Long getCook() {
        return cook;
    }

    public void setCook(Long cook) {
        this.cook = cook;
    }


    public Long getSt() {
        return st;
    }

    public void setSt(Long st) {
        this.st = st;
    }

    public Long getWind() {
        return wind;
    }

    public void setWind(Long wind) {
        this.wind = wind;
    }

    public Long getPer() {
        return per;
    }

    public void setPer(Long per) {
        this.per = per;
    }

    public Long getEl() {
        return el;
    }

    public void setEl(Long el) {
        this.el = el;
    }
}