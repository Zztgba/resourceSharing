package priv.luruidi.dao;

import java.util.Map;

import priv.luruidi.bean.User;

/**
 * @author 卢瑞迪
 * @date 2017年11月28日 下午1:16:49
 * @version V1.0
 * @Description TODO
 */
public interface UserDao {
	public Integer saveUser(User user);
	public User queryByName(String name);
	public Map<String,Object> queryMyself(Integer userid);
}
