package dao.model;

import movie.dao.bean.FriendBean;

import movie.dao.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FriendModel extends JpaRepository<FriendBean,Integer>{
    @Query("select u2 from UserBean u2 where u2.phone in (select f.user2 from  FriendBean f where f.user1=?1)")
    List<UserBean> findAllByUser1Id(String phone);

    @Query("select u1 from UserBean u1 where u1.phone in (select f.user1 from FriendBean f where  f.user2=?1)")
    List<UserBean> findAllByUser2Id(String phone);


    @Transactional
    @Modifying
    @Query("delete from FriendBean where (user1=?1 and user2=?2) or(user2=?1 and user1=?2)")
    void deleteByPhone(String phone1,String phone2);
}