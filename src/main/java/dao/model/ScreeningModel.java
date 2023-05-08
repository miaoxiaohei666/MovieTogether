package dao.model;

import movie.dao.bean.ScreeningBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreeningModel extends JpaRepository<ScreeningBean, Integer> {
    @Query("select s.time as time, m.name as movie_name, c.name as cinema_name from ScreeningBean s join MovieBean m on m.id = s.movieId join CinemaBean c on c.id = s.cinemaId where s.movieId = ?1")
    List<Screening> findAllByMovieId(Integer movieId);

    interface Screening {}
}
