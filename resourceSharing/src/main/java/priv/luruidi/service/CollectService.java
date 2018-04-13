package priv.luruidi.service;

import java.util.List;
import java.util.Map;

import priv.luruidi.bean.Collect;
import priv.luruidi.util.Page;

public interface CollectService{
	Integer saveCollect(Collect collect);
	Integer queryCollectListCount(Integer userid);
	List<Map<String,String>> queryCollectList(Integer userid,Page page);
	Integer countResource(Integer userid, Integer resourceid);
}
