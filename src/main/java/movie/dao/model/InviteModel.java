package movie.dao.model;

import movie.dao.bean.InviteBean;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface InviteModel extends JpaRepository<InviteBean,Integer>{
    List<InviteBean> findByReceiver(Integer receiver);
    List<InviteBean> findByInviterAndReceiver(Integer inviter,Integer receiver);
}