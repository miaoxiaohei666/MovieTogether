package movie.dao.model;

import movie.dao.bean.UserBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserModel extends JpaRepository<UserBean, Integer> {
    UserBean getUserBeanById(Integer id);

    UserBean getUserBeanByStunb(Integer stunb);


}
