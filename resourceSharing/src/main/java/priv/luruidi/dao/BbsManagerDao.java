package priv.luruidi.dao;

import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;

import java.util.List;

public interface BbsManagerDao {
    List<BbsVo> queryBbsByStatuState(Bbs bbs);
    int updateBbsState(Bbs bbs);
}
