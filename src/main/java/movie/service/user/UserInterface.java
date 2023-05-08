package movie.service.user;

import movie.dao.bean.UserBean;

import java.util.List;

public interface UserInterface {

    String SendCode(String phone);

    //登录时信息核对
//    UserBean loginIn(UserBean userBean);

    UserBean getUserByPhone(String phone);

    //根据ID查询用户信息
//    UserBean queryUserById(String id);

    //插入新的用户
    void addUser(UserBean userBean);
    //根据地址和标签获取用户信息
    List<UserBean> getUserByLabelAndAddress(String address, String label);
//
//    //删除用户
//    int dropUser(String id);
//
//    //修改用户
//    int modifyUser(UserBean userBean);
//
//    //查询所有用户
//    List<UserBean> queryAllUser();
}