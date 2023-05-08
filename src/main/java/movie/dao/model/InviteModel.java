package movie.dao.model;

import movie.dao.bean.InviteBean;

import movie.dao.bean.MovieBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InviteModel extends JpaRepository<InviteBean,Integer>{
    @Query("select u.name as inviter_name, c.inviter as inviter_phone from InviteBean c join UserBean u on u.phone = c.inviter where c.receiver = ?1")
    List<Invite> findAllByReceiverPhone(String phone);
    interface Invite{}
    @Transactional
    @Modifying
    @Query("delete from InviteBean  where inviter=?1 and receiver=?2")
    void delInviteByPhone(String inviter,String receiver);


}