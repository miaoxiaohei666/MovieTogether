package movie.dao.model;

import movie.dao.bean.CinemaBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaModel extends JpaRepository<CinemaBean,Integer>{
    CinemaBean getById(Integer id);
}