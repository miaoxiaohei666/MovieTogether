package dao.model;

import movie.dao.bean.ChatBean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChatModel extends JpaRepository<ChatBean, Integer> {
    @Query("select c.content as content, u.name as sender_name, c.sender as sender_phone from ChatBean c join UserBean u on u.phone = c.sender where c.sender=?1 and c.receiver = ?2")
    List<Message> findByPhone(String phone1,String phone2);

    interface Message{}

    @Transactional
    @Modifying
    @Query("delete from ChatBean where sender = ?1 and receiver=?2")
    void delMessageByPhone(String phone1,String phone2);
}
