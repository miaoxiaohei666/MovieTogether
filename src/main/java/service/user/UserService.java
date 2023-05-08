package service.user;

import movie.dao.model.UserModel;
import movie.dao.bean.UserBean;
import movie.service.user.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.List;

@Service
public class UserService implements UserInterface {

    @Autowired
    UserModel userModel;

    public UserBean getUserByPhone(String phone) {
        return userModel.findByPhone(phone);
    }
    public List<UserBean> getUserByLabelAndAddress(String address,String label){
        return userModel.getUserByLabelAndAddress(address,label);
    }

    @Override
    public String SendCode(String phone) {
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        String ACCOUNT_SID = "AC66df54d3f05e5d8b15e9ef7263d2850f";
        String AUTH_TOKEN = "dfe0bbf8d9cfc1f24044e854dae707d6";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        try {
            Message.creator(new PhoneNumber("+86" + phone), new PhoneNumber("+18607734058"), "[一起看电影吧] 你的验证码是" + code).create();
        } catch (Exception e) {
            System.err.println(e);
        }

        return code;
    }

//    @Override
//    public UserBean loginIn(UserBean userBean) {
//        return userMapper.getInfo(userBean);
//    }

    //    @Override
//    public UserBean queryUserById(String id) {
//        return userMapper.selectUserById(id);
//    }
//
    @Override
    public void addUser(UserBean userBean) {
        userModel.save(userBean);
    }
//    @Override
//    public int dropUser(String id) {
//        int dFlag = userMapper.deleteUser(id);
//        return dFlag;
//    }

//    @Override
//    public int modifyUser(UserBean userBean) {
//        int mFlag = userMapper.updateUser(userBean);
//        return mFlag;
//    }

//    @Override
//    public List<UserBean> queryAllUser() {
//        return userMapper.getAllUser();
//    }
}