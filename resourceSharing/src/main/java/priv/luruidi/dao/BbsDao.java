package priv.luruidi.dao;

import priv.luruidi.bean.Bbs;
import priv.luruidi.bean.vo.BbsVo;
import priv.luruidi.util.Page;

import java.util.List;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 16:49:42
 */
public interface BbsDao {
    Integer saveBbs(Bbs bbs);
    List<BbsVo> queryBbsList(Page page);
    Integer queryBbsListCount();
    Bbs bbsDetail(Integer id);
}
