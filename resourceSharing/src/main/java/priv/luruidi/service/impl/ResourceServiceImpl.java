package priv.luruidi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import priv.luruidi.bean.Resource;
import priv.luruidi.dao.ResourceDao;
import priv.luruidi.service.ResourceService;
import priv.luruidi.util.Page;

/**
 * @author 卢瑞迪
 * @date 2017年12月5日 下午4:32:58
 * @version V1.0
 * @Description TODO
 */
@Service
public class ResourceServiceImpl implements ResourceService{
	@javax.annotation.Resource
	private ResourceDao resouceDao;

	@Override
	public Integer saveResource(Resource resource) {
		return resouceDao.saveResource(resource);
	}

	@Override
	public Integer queryResourceCount() {
		return resouceDao.queryResourceCount();
	}

	@Override
	public List<Map<String, Object>> queryResource(Page page) {
		return resouceDao.queryResource(page);
	}

	@Override
	public Resource resourceDetail(Integer resourceId) {
		return resouceDao.resourceDetail(resourceId);
	}

}
