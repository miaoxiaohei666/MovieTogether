package dao.model;

import movie.dao.bean.UserBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserModel extends JpaRepository<UserBean, Integer> {
    UserBean findByPhone(String phone);
    boolean existsByPhone(String phone);

    @Query(value = "select u from UserBean u where u.address=?1 and u.label1=?2 or u.label2=?2 or u.label3=?2")
    List<UserBean> getUserByLabelAndAddress(String address, String label);
}
