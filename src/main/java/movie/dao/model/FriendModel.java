package movie.dao.model;

import movie.dao.bean.FriendBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendModel extends JpaRepository<FriendBean,Integer>{
    List<FriendBean> findAllByUserid(Integer userid);

    List<FriendBean> findAllByFriendid(Integer friendId);

    FriendBean getByUseridAndFriendid(Integer userid, Integer friendid);
}