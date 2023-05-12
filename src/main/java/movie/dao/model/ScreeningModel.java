package movie.dao.model;

import movie.dao.bean.ScreeningBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScreeningModel extends JpaRepository<ScreeningBean, Integer> {


    List<ScreeningBean> findAllByMovieid(Integer movie_id);
}
