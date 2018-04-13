package priv.luruidi.dao;

import java.util.List;
import java.util.Map;

import priv.luruidi.bean.Collect;
import priv.luruidi.util.Page;

public interface CollectDao {
	Integer saveCollect(Collect collect);
	Integer queryCollectListCount(Integer userId);
	List<Map<String,String>> queryCollectList(Integer userid,Page page);
	Integer countResource(Integer userid, Integer resourceid);
}
