package service.friend;

import movie.dao.bean.*;
import movie.dao.model.*;
import movie.service.friend.FriendInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService implements FriendInterface {

    @Autowired
    FriendModel friendModel;

    @Autowired
    InviteModel inviteModel;

    @Autowired
    ChatModel chatModel;

    @Autowired
    UserModel userModel;
    @Autowired
    MovieModel movieModel;


    @Override
    public void createMessage(String content, String sender, String receiver) {
        ChatBean chatBean = new ChatBean();
        chatBean.setSender(sender);
        chatBean.setReceiver(receiver);
        chatBean.setContent(content);
        chatModel.save(chatBean);
    }
    @Override
    public void creatInvite(String Inviter,String receiver){
        InviteBean inviteBean = new InviteBean();
        inviteBean.setInviter(Inviter);
        inviteBean.setReceiver(receiver);
        inviteModel.save(inviteBean);
    }

    @Override
    public List<MovieBean> getMovieBylabel(String inviter, String receiver){
        UserBean user1= userModel.findByPhone(inviter);
        UserBean user2= userModel.findByPhone(receiver);
        List<String> list =new ArrayList<>();
        List<String> list2 =new ArrayList<>();
        List<MovieBean> list3 =new ArrayList<>();
        list.add(user1.getLabel1());
        list.add(user1.getLabel2());
        list.add(user1.getLabel3());
        if(list.contains(user2.getLabel1())){
            list2.add(user2.getLabel1());
        }
        if(list.contains(user2.getLabel2())){
            list2.add(user2.getLabel2());
        }
        if(list.contains(user2.getLabel3())){
            list2.add(user2.getLabel3());
        }
        System.out.println(list2);
        for(String label:list2){
            list3.addAll(movieModel.findAllByLabel(label));
        }
        return list3;
    }
    @Override
    public List<ChatModel.Message> getMessage(String phone1,String phone2) {
        return chatModel.findByPhone(phone1,phone2);
    }

    @Override
    public List<UserBean> getFriendList2(String phone) {
        return friendModel.findAllByUser1Id(phone);
    }
    @Override
    public List<UserBean> getFriendList1(String phone) {
        return friendModel.findAllByUser2Id(phone);
    }
    @Override
    public void addFriend(FriendBean friendBean) {
        friendModel.save(friendBean);
    }
    @Override
    public boolean checkPhone(String phone){
        return userModel.existsByPhone(phone);
    }

    @Override
    public void delFriend(String phone1,String phone2){
        friendModel.deleteByPhone(phone1,phone2);
    }
    @Override
    public void delChatMessageByPhone(String phone1,String phone2){
        chatModel.delMessageByPhone(phone1,phone2);
    }
    @Override
    public void delInviteByPhone(String inviter,String phone){inviteModel.delInviteByPhone(inviter,phone);}
    @Override
    public List <InviteModel.Invite> getInvite(String phone){
        return inviteModel.findAllByReceiverPhone(phone);
    }

}