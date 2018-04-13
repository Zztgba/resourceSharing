package priv.luruidi.service;

import priv.luruidi.bean.BbsComment;
import priv.luruidi.bean.vo.BbsCommentVo;
import priv.luruidi.util.Page;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/27 14:48:43
 */
public interface BbsCommentService {
    List<BbsCommentVo> queryBbsCommentList(Integer id,Page page);
    Integer countBbsCommentList(Integer bbsid);
    Integer saveBbsComment(BbsComment bbsComment);
}
