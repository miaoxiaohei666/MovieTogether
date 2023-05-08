package movie.service.user;

import movie.dao.model.UserModel;
import movie.dao.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    UserModel userModel;

    public UserBean getUserByID(Integer id) {
        return userModel.getUserBeanById(id);
    }

    public UserBean getUserByStunb(Integer stunb) {
        return userModel.getUserBeanByStunb(stunb);
    }

    public List<UserBean> getUserByLabel(String label) {
        return userModel.findAllByLabel1OrLabel2OrLabel3(label, label, label);
    }
}