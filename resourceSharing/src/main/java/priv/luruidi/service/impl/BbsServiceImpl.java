package priv.luruidi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;
import priv.luruidi.dao.BbsDao;
import priv.luruidi.service.BbsService;
import priv.luruidi.util.Page;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 16:49:07
 */
@Service
public class BbsServiceImpl implements BbsService{
    @Autowired
    private BbsDao bbsDao;
    @Override
    public Integer saveBbs(Bbs bbs) {
        return bbsDao.saveBbs(bbs);
    }

    @Override
    public List<BbsVo> queryBbsList(Page page) {
        return bbsDao.queryBbsList(page);
    }

    @Override
    public Integer queryBbsListCount() {
        return bbsDao.queryBbsListCount();
    }

    @Override
    public Bbs bbsDetail(Integer id) {
        return bbsDao.bbsDetail(id);
    }
}
