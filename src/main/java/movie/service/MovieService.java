package movie.service;

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
    ScreeningModel screeningModel;
    @Autowired
    UserModel userModel;

    public List<ScreeningModel.Screening> getScreeningByMovieId(Integer movieId) {
        return screeningModel.findAllByMovieId(movieId);
    }

}