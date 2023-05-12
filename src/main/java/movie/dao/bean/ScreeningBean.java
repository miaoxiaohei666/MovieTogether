package movie.dao.bean;

import javax.persistence.*;

@Entity
@Table(name = "screenings")
public class ScreeningBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cinemaid;
    private Integer movieid;
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(Integer cinema_id) {
        this.cinemaid = cinema_id;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movie_id) {
        this.movieid = movie_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
