package movie.controller;

import com.alibaba.fastjson.JSONObject;
import movie.dao.bean.FriendBean;
import movie.dao.bean.MovieBean;
import movie.dao.bean.UserBean;
import movie.dao.model.ChatModel;
import movie.dao.model.FriendModel;
import movie.dao.model.InviteModel;
import movie.dao.model.UserModel;
import movie.service.friend.FriendInterface;
import movie.service.friend.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.JWT;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class FriendController {
    @Autowired
    FriendInterface friendService;
    @Autowired
    UserModel userModel;
    //发消息
    @PostMapping(value = "/chat/create")
    public String createMessage(@RequestBody JSONObject request) {
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }

        friendService.createMessage(request.getString("content"), phone, request.getString("receiver"));

        response.put("msg", "ok");
        return response.toString();
    }
    //收消息
    @PostMapping(value = "/chat/get")
    public String getMessage(@RequestBody JSONObject request) {
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        List<ChatModel.Message> list = friendService.getMessage(request.getString("sender"),phone);
        friendService.delChatMessageByPhone(request.getString("sender"),phone);
        response.put("list", list);
        response.put("msg", "ok");
        return response.toString();
    }
    //添加好友
    @PostMapping(value = "/friend/add")
    public String addFriend(@RequestBody JSONObject request){
        JSONObject response = new JSONObject();
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        String phone2= request.getString("phone");
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        if(!friendService.checkPhone(request.getString("phone"))){
            response.put("msg","phone is not exist!");
            return response.toString();
        }
        //判断是否已经加了好友
        List<UserBean> list2 = friendService.getFriendList2(phone);
        List<UserBean> list1 = friendService.getFriendList1(phone);
        list2.addAll(list1);
        for(UserBean u:list2){
            if(phone2.equals(u.getPhone())){
                response.put("msg", "already add!");
                return response.toString();
            }
        }

        FriendBean friend = new FriendBean();
        friend.setUser1(phone);
        friend.setUser2(request.getString("phone"));

        friendService.addFriend(friend);
        response.put("msg", "ok");
        return response.toString();
    }

    //删除好友
    @PostMapping(value = "/friend/delete")
    public String deleteFriend(@RequestBody JSONObject request){
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        String phone2= request.getString("phone");
        JSONObject response = new JSONObject();

        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        if(!friendService.checkPhone(phone2)){
            response.put("msg","phone is not exist!");
            return response.toString();
        }
        //判断是否已经加了好友
        List<UserBean> list2 = friendService.getFriendList2(phone);
        List<UserBean> list1 = friendService.getFriendList1(phone);
        list2.addAll(list1);
        for(UserBean u:list2){
            if(phone2.equals(u.getPhone())){
                friendService.delFriend(phone,phone2);
                response.put("msg", "delete success!");
                return response.toString();
            }
        }
        response.put("msg","no this friend!");
        return response.toString();
    }

    //好友列表
    @PostMapping(value = "/friend/list")
    public String friendList(@RequestBody JSONObject request){
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        List<UserBean> list2 = friendService.getFriendList2(phone);
        List<UserBean> list1 = friendService.getFriendList1(phone);
        list2.addAll(list1);
        System.out.println(list2);
        response.put("list", list2);
        response.put("msg", "ok");
        return response.toString();
    }
    //发送邀约
    @PostMapping(value = "/invite/create")
    public String createInvite(@RequestBody JSONObject request){
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        friendService.creatInvite(phone,request.getString("receiver"));
        response.put("msg","ok");
        return response.toString();
    }

    //收邀约
    @PostMapping(value = "/invite/get")
    public String getInvite(@RequestBody JSONObject request) {
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        System.out.println(phone);
        System.out.println(phone);
        List<InviteModel.Invite> list = friendService.getInvite(phone);
        System.out.println(list);
        System.out.println(list);
        response.put("list",list);
        response.put("msg", "ok");
        return response.toString();
    }
    //处理邀约
    @PostMapping(value = "/invite/accept")
    public String acceptInvite(@RequestBody JSONObject request){
        String token = request.getString("token");
        String phone = JWT.parsePhoneFromToken(token);
        JSONObject response = new JSONObject();
        String flag = request.getString("flag");
        String inviter = request.getString("inviter");
        if (phone.equals("")) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        if(flag.equals("")){
            response.put("msg","已拒绝邀约");
            friendService.delInviteByPhone(inviter,phone);
            return response.toString();
        }
        List<MovieBean> list = friendService.getMovieBylabel(inviter,phone);
        System.out.println(phone);
        System.out.println(inviter);
        System.out.println(list);
        response.put("list",list);
        response.put("msg","ok");
        return response.toString();
    }
}
