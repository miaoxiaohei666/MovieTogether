package movie.service.movie;

import movie.dao.bean.MovieBean;
import movie.dao.bean.ScreeningBean;
import movie.dao.model.ScreeningModel;

import java.util.List;

public interface MovieInterface {
    List<ScreeningModel.Screening> getScreeningByMovieId(Integer movieId);
}