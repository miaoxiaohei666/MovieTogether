package movie.controller;

import com.alibaba.fastjson.JSONObject;
import movie.dao.bean.FriendBean;
import movie.dao.bean.InviteBean;
import movie.dao.bean.MovieBean;
import movie.dao.bean.UserBean;
import movie.dao.model.FriendModel;
import movie.dao.model.UserModel;
import movie.service.FriendService;
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
    FriendService friendService;
    @Autowired
    UserModel userModel;

    @Autowired
    FriendModel friendModel;

    //发送添加好友申请
    @PostMapping(value = "/friend/add")
    public String addFriend(@RequestBody JSONObject request) {
        JSONObject response = new JSONObject();
        String token = request.getString("token");
        Integer userid = Integer.valueOf(JWT.parseUserIDFromToken(token));
        Integer friendid = request.getInteger("friendid");
        if (userid.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        //判断是否已经发送了好友申请
        List<UserBean> friendList = friendService.getFriendList(userid);
        List<UserBean> userList = friendService.getUserList(friendid);
        for (UserBean u : friendList) {
            if (friendid.equals(u.getId())) {
                response.put("msg", "already add!");
                return response.toString();
            }
        }

        FriendBean friend = new FriendBean();
        friend.setFriendid(friendid);
        friend.setUserid(userid);
        friendService.addFriend(friend);
        response.put("msg", "ok");
        return response.toString();
    }

    //接受添加好友申请
    @PostMapping(value = "/friend/accept")
    public String acceptFriend(@RequestBody JSONObject request) {
        JSONObject response = new JSONObject();
        Integer id = request.getInteger("id");
        if (!friendService.existById(id)) {
            response.put("msg", "id is not exist!");
            return response.toString();
        }

        FriendBean friend = new FriendBean();
        friend.setFriendid(friendModel.getById(id).getUserid());
        friend.setUserid(friendModel.getById(id).getFriendid());
        friendService.addFriend(friend);
        response.put("msg", "ok");
        return response.toString();
    }

    //删除好友
    @PostMapping(value = "/friend/delete")
    public String deleteFriend(@RequestBody JSONObject request) {
        String token = request.getString("token");
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(token));
        Integer friendid = request.getInteger("friendid");
        JSONObject response = new JSONObject();
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        if (friendService.findByUseridAndFriend(id, friendid) == null) {
            response.put("msg", "student number is not exist!");
            return response.toString();
        }
        //判断是否已经加了好友

        friendService.delFriend(id, friendid);
        friendService.delFriend(friendid, id);
        response.put("msg", "delete success!");
        return response.toString();
    }

    //好友列表
    @PostMapping(value = "/friend/list")
    public String friendList(@RequestBody JSONObject request) {
        String token = request.getString("token");
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(token));
        JSONObject response = new JSONObject();
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        response.put("list", friendService.getFriendList(id));
        response.put("msg", "ok");
        return response.toString();
    }

    //发送邀约
    @PostMapping(value = "/invite/create")
    public String createInvite(@RequestBody JSONObject request) {
        String token = request.getString("token");
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(token));
        JSONObject response = new JSONObject();
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        friendService.creatInvite(id, Integer.valueOf(request.getString("receiver")));
        response.put("msg", "ok");
        return response.toString();
    }

    //收邀约
    @PostMapping(value = "/invite/get")
    public String getInvite(@RequestBody JSONObject request) {
        String token = request.getString("token");
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(token));
        JSONObject response = new JSONObject();
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        List<InviteBean> idlist = friendService.getInviteList(id);
        List<UserBean> list = new ArrayList<>();
        for (InviteBean i:idlist){
            list.add(userModel.getUserBeanById(i.getInviter()));
        }
        response.put("list", list);
        response.put("msg", "ok");
        return response.toString();
    }

    //处理邀约
    @PostMapping(value = "/invite/accept")
    public String acceptInvite(@RequestBody JSONObject request) {
        String token = request.getString("token");
        Integer id = Integer.valueOf(JWT.parseUserIDFromToken(token));
        JSONObject response = new JSONObject();
        String flag = request.getString("flag");
        Integer inviter = Integer.valueOf(request.getString("inviter"));
        if (id.equals(0)) {
            response.put("msg", "token wrong!");
            return response.toString();
        }
        if (flag.equals("")) {
            response.put("msg", "已拒绝邀约");
            friendService.delInvite(id,inviter);
            return response.toString();
        }
        List<MovieBean> list = friendService.getMovieBylabel(inviter,id);
        response.put("list", list);
        response.put("msg", "ok");
        return response.toString();
    }
}
