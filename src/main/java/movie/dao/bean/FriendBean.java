package movie.dao.bean;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class FriendBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userid;
    private Integer friendid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer user_id) {
        this.userid = user_id;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friend_id) {
        this.friendid = friend_id;
    }
}
