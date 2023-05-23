package movie.service;

import movie.dao.bean.CinemaBean;
import movie.dao.bean.ScreeningBean;
import movie.dao.model.CinemaModel;
import movie.dao.model.MovieModel;
import movie.dao.model.ScreeningModel;
import movie.dao.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService{

    @Autowired
    MovieModel movieModel;

    @Autowired
    CinemaModel cinemaModel;

    @Autowired
    ScreeningModel screeningModel;
    @Autowired
    UserModel userModel;

    public List<ScreeningBean> getScreeningByMovieId(Integer movie_id) {
        return screeningModel.findAllByMovieid(movie_id);
    }
    public CinemaBean getCinemaInfo(Integer cinema_id) {
        return cinemaModel.getById(cinema_id);
    }

}