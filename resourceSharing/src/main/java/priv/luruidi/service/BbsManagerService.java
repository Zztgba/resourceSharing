package priv.luruidi.service;

import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;

import java.util.List;

public interface BbsManagerService {
    List<BbsVo> queryBbsByStatuState(Bbs bbs);
    int updateBbsState(Bbs bbs);
}
