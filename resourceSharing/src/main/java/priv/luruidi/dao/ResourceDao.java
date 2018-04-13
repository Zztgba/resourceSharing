package priv.luruidi.dao;

import java.util.List;
import java.util.Map;

import priv.luruidi.bean.Resource;
import priv.luruidi.util.Page;

/**
 * @author 卢瑞迪
 * @date 2017年12月5日 下午4:20:51
 * @version V1.0
 * @Description TODO
 */
public interface ResourceDao {
	Integer saveResource(Resource resource);
	Integer queryResourceCount();
	List<Map<String,Object>> queryResource(Page page);
	Resource resourceDetail(Integer resourceId);
}
