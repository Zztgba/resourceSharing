package priv.luruidi.service;

import java.util.Map;

import priv.luruidi.bean.User;

/**
 * @author 卢瑞迪
 * @date 2017年11月28日 下午1:20:13
 * @version V1.0
 * @Description TODO
 */
public interface UserService {
	public Map<String, String> saveUser(User user);
	public Map<String,Object> login(String name, String password);
	public Map<String,Object> queryMyself(Integer userid);
}
