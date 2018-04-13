package priv.luruidi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import priv.luruidi.bean.User;
import priv.luruidi.dao.UserDao;
import priv.luruidi.service.UserService;

/**
 * @author 卢瑞迪
 * @date 2017年11月28日 下午1:23:01
 * @version V1.0
 * @Description TODO
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	@Override
	public Map<String,String> saveUser(User user) {
		Integer count = userDao.saveUser(user);
		Map<String,String> map=new HashMap<>();
		if(count==1){
			map.put("flag", "success");
		}
		return map;
	}
	@Override
	public Map<String, Object> login(String name, String password) {
		User user = userDao.queryByName(name);
		Map<String,Object> map=new HashMap<>();
		if(user==null){
			map.put("flag", "failed");
			map.put("mes", "用户名不存在,请重新输出！");
		}else{
			if(!user.getPassword().equals(password)){
				map.put("flag", "failed");
				map.put("mes", "密码有误,请重新输入！");
			}else{
				map.put("flag", "success");
				map.put("user", user);
			}
		}
		return map;
	}
	@Override
	public Map<String, Object> queryMyself(Integer userid) {
		return userDao.queryMyself(userid);
	}
}
