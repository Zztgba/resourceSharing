package priv.luruidi.dao;

import priv.luruidi.bean.BbsCommentReply;
import priv.luruidi.bean.vo.BbsCommentReplyVo;

import java.util.List;

public interface BbsCommentReplyDao {
    List<BbsCommentReplyVo> queryBbsCommentReplyVoList(BbsCommentReply bbsCommentReply );
    int countReplys(BbsCommentReply bbsCommentReply);
    int saveBbsCommentReply(BbsCommentReply bbsCommentReply);
}
