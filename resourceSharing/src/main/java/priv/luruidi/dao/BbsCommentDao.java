package priv.luruidi.dao;

import priv.luruidi.bean.BbsComment;
import priv.luruidi.bean.vo.BbsCommentVo;
import priv.luruidi.util.Page;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/27 14:35:00
 */
public interface BbsCommentDao {
    List<BbsCommentVo> queryBbsCommentList(Integer id,Page page);
    Integer countBbsCommentList(Integer bbsid);
    Integer saveBbsComment(BbsComment bbsComment);
}
