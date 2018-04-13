package priv.luruidi.service;

import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;
import priv.luruidi.util.Page;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 16:48:22
 */
public interface BbsService {
    Integer saveBbs(Bbs bbs);
    List<BbsVo> queryBbsList(Page page);
    Integer queryBbsListCount();
    Bbs bbsDetail(Integer id);
}
