package movie.controller;

import com.alibaba.fastjson.JSONObject;
import movie.dao.bean.UserBean;
import movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.JWT;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    // 密码登录
    @PostMapping(value = "/user/login")
    public String login(@RequestBody JSONObject requestUser) {
        JSONObject response = new JSONObject();
        UserBean userBean = userService.getUserByStunb(requestUser.getInteger("stunb"));
        if (userBean == null) {
            response.put("msg", "未查询到该用户");
            return response.toString();
        }
        if (!Objects.equals(userBean.getPassword(), requestUser.getString("password"))) {
            response.put("msg", "密码错误");
            return response.toString();
        }

        String token = JWT.getToken(userBean.getId());

        response.put("msg", "登录成功");
        response.put("token", token);
        return response.toString();
    }

    // 注册和学号登录
    @PostMapping(value = "/user/signup")
    public String register(@RequestBody JSONObject request) {
        JSONObject response = new JSONObject();
        if (userService.getUserByStunb(request.getInteger("stunb")) == null) { // 注册
            UserBean user = new UserBean();
            user.setStunb(request.getInteger("stunb"));
            user.setPassword(request.getString("password"));
            user.setNickname(request.getString("name"));
            user.setSex(request.getString("sex"));
            user.setAge(request.getInteger("age"));
            user.setLabel1(request.getString("label1"));
            user.setLabel2(request.getString("label2"));
            user.setLabel3(request.getString("label3"));
            userService.addUser(user);
        }
        String token = JWT.getToken(request.getInteger("stunb"));
        response.put("msg", "登录成功");
        response.put("token", token);
        return response.toString();
    }

    //查询个人信息
    @PostMapping(value = "/user/info")
    public String getInfo(@RequestBody JSONObject request) {
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(request.getString("token")));
        JSONObject response = new JSONObject();
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        UserBean user = userService.getUserByID(id);
        response.put("msg", "查询成功");
        JSONObject userInfo = new JSONObject();
        userInfo.put("id", user.getId());
        userInfo.put("stunb", user.getStunb());
        userInfo.put("name", user.getNickname());
        userInfo.put("sex", user.getSex());
        userInfo.put("age", user.getAge());
        userInfo.put("label1", user.getLabel1());
        userInfo.put("label2", user.getLabel2());
        userInfo.put("label3", user.getLabel3());
        response.put("data", userInfo);
        return response.toString();
    }

    //通过学号获取用户信息
    @PostMapping(value = "/user/getbystunb")
    public String getUserByStunb(@RequestBody JSONObject request) {
        JSONObject response = new JSONObject();
        UserBean user = userService.getUserByStunb(request.getInteger("stunb"));
        if (user == null) {
            response.put("msg", "该用户不存在！");
            return response.toString();
        }
        response.put("msg", "查询成功");
        JSONObject userInfo = new JSONObject();
        userInfo.put("id", user.getId());
        userInfo.put("stunb", user.getStunb());
        userInfo.put("name", user.getNickname());
        userInfo.put("sex", user.getSex());
        userInfo.put("age", user.getAge());
        userInfo.put("label1", user.getLabel1());
        userInfo.put("label2", user.getLabel2());
        userInfo.put("label3", user.getLabel3());
        response.put("data", userInfo);
        return response.toString();
    }

    //修改个人信息
    @PostMapping(value = "/user/update")
    public String updateInfo(@RequestBody JSONObject request) {
        String token = request.getString("token");
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(token));
        JSONObject response = new JSONObject();
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        UserBean user = userService.getUserByID(id);
        user.setStunb(request.getInteger("stunb"));
        user.setPassword(request.getString("password"));
        user.setNickname(request.getString("name"));
        user.setSex(request.getString("sex"));
        user.setAge(request.getInteger("age"));
        user.setLabel1(request.getString("label1"));
        user.setLabel2(request.getString("label2"));
        user.setLabel3(request.getString("label3"));
        userService.addUser(user);
        response.put("msg", "success!");
        return response.toString();
    }

    //根据标签获取用户群
    @PostMapping(value = "/user/label")
    public String getUserByLabel(@RequestBody JSONObject request) {
        String label = request.getString("label");
        JSONObject response = new JSONObject();
        List<UserBean> list = userService.getUserByLabel(label);
        response.put("list", list);
        return response.toString();
    }

    //获取用户群
    @PostMapping(value = "/user/list")
    public String getAllUser() {
        JSONObject response = new JSONObject();
        List<UserBean> list = userService.findAllUser();
        response.put("list", list);
        return response.toString();
    }
}