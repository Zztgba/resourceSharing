package priv.luruidi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.luruidi.bean.BbsCommentReply;
import priv.luruidi.bean.vo.BbsCommentReplyVo;
import priv.luruidi.dao.BbsCommentReplyDao;
import priv.luruidi.service.BbsCommentReplyService;

import java.util.List;
@Service
public class BbsCommentReplyServiceImpl implements BbsCommentReplyService {
    @Autowired
    private BbsCommentReplyDao bbsCommentReplyDao;
    @Override
    public List<BbsCommentReplyVo> queryBbsCommentReplyVoList(BbsCommentReply bbsCommentReply) {
        return bbsCommentReplyDao.queryBbsCommentReplyVoList(bbsCommentReply);
    }

    @Override
    public int countReplys(BbsCommentReply bbsCommentReply) {
        return bbsCommentReplyDao.countReplys(bbsCommentReply);
    }

    @Override
    public int saveBbsCommentReply(BbsCommentReply bbsCommentReply) {
        return bbsCommentReplyDao.saveBbsCommentReply(bbsCommentReply);
    }
}
