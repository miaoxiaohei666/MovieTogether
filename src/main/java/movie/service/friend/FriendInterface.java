package movie.service.friend;

import movie.dao.bean.*;
import movie.dao.model.ChatModel;
import movie.dao.model.InviteModel;

import java.util.List;

public interface FriendInterface {

    void createMessage(String content, String sender, String receiver);

    List<ChatModel.Message> getMessage(String phone1,String phone2);
    List<UserBean> getFriendList2(String phone);
    List<UserBean> getFriendList1(String phone);
    void addFriend(FriendBean friendBean);
    boolean checkPhone(String phone);
    void delFriend(String phone1,String phone2);
    void delChatMessageByPhone(String phone1,String phone2);
    void creatInvite(String Inviter,String receiver);
    List <InviteModel.Invite> getInvite(String phone);
    void delInviteByPhone(String inviter,String phone);
    List<MovieBean> getMovieBylabel(String inviter, String receiver);
}