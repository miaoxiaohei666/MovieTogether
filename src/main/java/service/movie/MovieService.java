package service.movie;

import movie.dao.bean.ScreeningBean;
import movie.dao.model.MovieModel;
import movie.dao.bean.MovieBean;
import movie.dao.model.ScreeningModel;
import movie.dao.model.UserModel;
import movie.service.movie.MovieInterface;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService implements MovieInterface {

    @Autowired
    MovieModel movieModel;

    @Autowired
    ScreeningModel screeningModel;
    @Autowired
    UserModel userModel;

    @Override
    public List<ScreeningModel.Screening> getScreeningByMovieId(Integer movieId) {
        return screeningModel.findAllByMovieId(movieId);
    }

}