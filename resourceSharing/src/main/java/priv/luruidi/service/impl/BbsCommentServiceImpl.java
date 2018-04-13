package priv.luruidi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.luruidi.bean.BbsComment;
import priv.luruidi.bean.vo.BbsCommentVo;
import priv.luruidi.dao.BbsCommentDao;
import priv.luruidi.service.BbsCommentService;
import priv.luruidi.util.Page;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/27 14:49:24
 */
@Service
public class BbsCommentServiceImpl implements BbsCommentService{
    @Autowired
    private BbsCommentDao bbsCommentDao;
    @Override
    public List<BbsCommentVo> queryBbsCommentList(Integer id,Page page) {
        return bbsCommentDao.queryBbsCommentList(id,page);
    }

    @Override
    public Integer countBbsCommentList(Integer bbsid) {
        return bbsCommentDao.countBbsCommentList(bbsid);
    }

    @Override
    public Integer saveBbsComment(BbsComment bbsComment) {
        return bbsCommentDao.saveBbsComment(bbsComment);
    }
}
