package movie.dao.model;

import movie.dao.bean.MovieBean;

import movie.dao.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieModel extends JpaRepository<MovieBean,Integer>{
    MovieBean findMovieById(Integer id);
    boolean existsMovieBeanByName(String name);
    List<MovieBean> findAllBySort(String label);

}