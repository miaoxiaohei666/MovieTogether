package controller;

import com.alibaba.fastjson.JSONObject;
import movie.dao.bean.UserBean;
import movie.dao.model.UserModel;
import movie.service.user.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.JWT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserInterface userService;
    @Autowired
    UserModel userModel;

    // 存手机号和验证码
    Map<String, String> map = new HashMap<>();

    // 密码登录
    @PostMapping(value = "/user/login")
    public String login(@RequestBody JSONObject requestUser) {
        JSONObject response = new JSONObject();
        UserBean userBean = userService.getUserByPhone(requestUser.getString("phone"));
        if (userBean == null) {
            response.put("msg", "未查询到该用户");
            return response.toString();
        }
        if (!Objects.equals(userBean.getPassword(), requestUser.getString("password"))) {
            response.put("msg", "密码错误");
            return response.toString();
        }

        String token = JWT.getToken(userBean.getPhone(), userBean.getRole());

        response.put("msg", "登录成功");
        response.put("token", token);
        return response.toString();
    }
    //验证码
    @PostMapping(value = "/user/message")
    public String sendMessage(@RequestBody JSONObject request) {
        String phone = request.getString("phone");
        String code = userService.SendCode(phone);
        map.put(phone, code);

        JSONObject response = new JSONObject();
        response.put("msg", "ok");
        return response.toString();
    }

    // 注册和手机号登录
    @PostMapping(value = "/user/signup")
    public String register(@RequestBody JSONObject request) {
        JSONObject response = new JSONObject();
        if (!Objects.equals(request.getString("code"), map.get(request.getString("phone")))) {
            response.put("msg", "验证码错误");
            return response.toString();
        }
        if (!userModel.existsByPhone(request.getString("phone"))) { // 注册
            UserBean user =new UserBean();
            user.setPhone(request.getString("phone"));
            userService.addUser(user);
        }
        String token = JWT.getToken(request.getString("phone"), 0);
        response.put("msg", "登录成功");
        response.put("token", token);
        return response.toString();
    }

    //查询个人信息
    @PostMapping(value = "/user/info")
    public String getInfo(@RequestBody JSONObject request) {
        String phone = JWT.parsePhoneFromToken(request.getString("token"));
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }

        UserBean user = userService.getUserByPhone(phone);

        response.put("addr", user.getAddress());
        response.put("name", user.getName());
        response.put("age", user.getAge());
        response.put("label1", user.getLabel1());
        response.put("label2", user.getLabel2());
        response.put("label3", user.getLabel3());
        response.put("sex", user.getSex());
        response.put("msg","ok");
        return response.toString();

    }
    //通过电话获取用户信息
    @PostMapping(value = "/user/getbyphone")
    public String getUserByPhone(@RequestBody JSONObject request){
        JSONObject response = new JSONObject();
        UserBean user = userService.getUserByPhone(request.getString("phone"));
        response.put("addr", user.getAddress());
        response.put("name", user.getName());
        response.put("age", user.getAge());
        response.put("label1", user.getLabel1());
        response.put("label2", user.getLabel2());
        response.put("label3", user.getLabel3());
        response.put("sex", user.getSex());
        response.put("msg","ok");
        return response.toString();
    }
    //修改个人信息
    @PostMapping(value = "/user/update")
    public String updateInfo(@RequestBody JSONObject request) {
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }

        UserBean user = userService.getUserByPhone(phone);
        user.setAddress(request.getString("address"));
        user.setName(request.getString("name"));
        user.setPassword(request.getString("password"));
        user.setLabel1(request.getString("label1"));
        user.setLabel2(request.getString("label2"));
        user.setLabel3(request.getString("label3"));
        user.setAge(request.getInteger("age"));
        user.setSex(request.getString("sex"));

        response.put("msg", "success!");
        return response.toString();
    }

    //根据标签和地址，获取用户群
    @PostMapping(value = "/user/label")
    public String getUserByLabelAndAddress(@RequestBody JSONObject request) {
         String label = request.getString("label");
         String address = request.getString("address");
         JSONObject response = new JSONObject();
         List<UserBean> list= userService.getUserByLabelAndAddress(address,label);
         System.out.println(list);
         response.put("list",list);
        return response.toString();
    }



}

//"token":"eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE1OTAzMDMyMzc2Iiwicm9sZSI6MSwianRpIjoiNWVmOThhNTMtYzQ1OS00ODIyLTgyMDItMWJjOGE5YTZiNWIzIiwiZXhwIjoxNjU3MzUwNjcwfQ.S44R6RGc6IZro6CAPbcRS3m_5IgWYh8qyvPd2v2XZeo"