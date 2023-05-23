package movie.dao.model;

import movie.dao.bean.UserBean;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserModel extends JpaRepository<UserBean, Integer> {
    UserBean getUserBeanById(Integer id);

    List<UserBean> findAll();

    UserBean getUserBeanByStunb(Integer stunb);

    List<UserBean> findAllByLabel1OrLabel2OrLabel3(String label1, String label2, String label3);

}
