package movie.dao.model;

import movie.dao.bean.FriendBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendModel extends JpaRepository<FriendBean,Integer>{
    List<FriendBean> findByUserid(Integer userid);

    List<FriendBean> findByFriendid(Integer friendid);

    FriendBean findByUseridAndFriendid(Integer userid, Integer friendid);
}