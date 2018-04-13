package priv.luruidi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import priv.luruidi.bean.Collect;
import priv.luruidi.dao.CollectDao;
import priv.luruidi.service.CollectService;
import priv.luruidi.util.Page;

@Service
public class CollectServiceImpl implements CollectService{
	@Resource
	private CollectDao collectDao;
	@Override
	public Integer saveCollect(Collect collect) {
		return collectDao.saveCollect(collect);
	}

	@Override
	public Integer queryCollectListCount(Integer userid) {
		return collectDao.queryCollectListCount(userid);
	}

	@Override
	public List<Map<String, String>> queryCollectList(Integer userid,Page page) {
		return collectDao.queryCollectList(userid,page);
	}
	@Override
	public Integer countResource(Integer userid, Integer resourceid) {
		return collectDao.countResource(userid, resourceid);
	}

}
