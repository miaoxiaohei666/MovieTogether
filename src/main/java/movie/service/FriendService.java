package movie.service;

import movie.dao.bean.*;
import movie.dao.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendModel friendModel;

    @Autowired
    InviteModel inviteModel;

    @Autowired
    UserModel userModel;
    @Autowired
    MovieModel movieModel;

    public void creatInvite(Integer inviter, Integer receiver) {
        InviteBean inviteBean = new InviteBean();
        inviteBean.setInviter(inviter);
        inviteBean.setReceiver(receiver);
        inviteBean.setTime(String.valueOf(LocalDateTime.now()));
        inviteModel.save(inviteBean);
    }

    public List<InviteBean> getInviteList(Integer user_id){
        return inviteModel.findByReceiver(user_id);
    }

    public void delInvite(Integer user_id, Integer friend_id) {
        List<InviteBean> list = inviteModel.findByInviterAndReceiver(user_id,friend_id);
        inviteModel.deleteAll(list);
    }

    public List<MovieBean> getMovieBylabel(Integer inviter, Integer receiver) {

        UserBean user1 = userModel.getUserBeanById(inviter);
        UserBean user2 = userModel.getUserBeanById(receiver);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<MovieBean> list3 = new ArrayList<>();
        list.add(user1.getLabel1());
        list.add(user1.getLabel2());
        list.add(user1.getLabel3());
        if (list.contains(user2.getLabel1())) {
            list2.add(user2.getLabel1());
        }
        if (list.contains(user2.getLabel2())) {
            list2.add(user2.getLabel2());
        }
        if (list.contains(user2.getLabel3())) {
            list2.add(user2.getLabel3());
        }
        System.out.println(list2);
        for (String label : list2) {
            list3.addAll(movieModel.findAllByLabel(label));
        }

        return list3;

    }

    public  boolean existById(Integer id){
        return userModel.existsById(id);
    }

    public List<UserBean> getFriendList(Integer user_id) {
        List<FriendBean> friendBeanList = friendModel.findByUserid(user_id);
        List<UserBean> userBeanList = new ArrayList<>();
        for (FriendBean friendBean : friendBeanList) {
            userBeanList.add(userModel.getUserBeanById(friendBean.getFriendid()));
        }
        return  userBeanList;
    }

    public List<UserBean> getUserList(Integer friend_id) {
        List<FriendBean> userBeanList = friendModel.findByFriendid(friend_id);
        List<UserBean> friendBeanList = new ArrayList<>();
        for (FriendBean friendBean : userBeanList) {
            friendBeanList.add(userModel.getUserBeanById(friendBean.getFriendid()));
        }
        return  friendBeanList;
    }

    public void addFriend(FriendBean friendBean) {
        friendModel.save(friendBean);
    }

    public void delFriend(Integer user_id, Integer friend_id) {
        friendModel.delete(friendModel.findByUseridAndFriendid(user_id,friend_id));
    }

    public FriendBean findByUseridAndFriend(Integer user_id, Integer friend_id){
       return friendModel.findByUseridAndFriendid(user_id,friend_id);
    }

}