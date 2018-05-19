package priv.luruidi.service;

import priv.luruidi.bean.BbsCommentReply;
import priv.luruidi.bean.vo.BbsCommentReplyVo;

import java.util.List;

public interface BbsCommentReplyService {
    List<BbsCommentReplyVo> queryBbsCommentReplyVoList(BbsCommentReply bbsCommentReply );
    int countReplys(BbsCommentReply bbsCommentReply);
    int saveBbsCommentReply(BbsCommentReply bbsCommentReply);
}
