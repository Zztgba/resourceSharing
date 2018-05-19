package priv.luruidi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;
import priv.luruidi.dao.BbsManagerDao;
import priv.luruidi.service.BbsManagerService;

import java.util.List;
@Service
public class BbsManagerServiceImpl implements BbsManagerService {
    @Autowired
    private BbsManagerDao bbsManagerDao;
    @Override
    public List<BbsVo> queryBbsByStatuState(Bbs bbs) {
        return bbsManagerDao.queryBbsByStatuState(bbs);
    }

    @Override
    public int updateBbsState(Bbs bbs) {
        return bbsManagerDao.updateBbsState(bbs);
    }
}
