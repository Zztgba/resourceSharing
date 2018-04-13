package priv.luruidi.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import priv.luruidi.bean.Score;
import priv.luruidi.bean.User;
import priv.luruidi.dao.UserDao;
import priv.luruidi.service.ResourceService;
import priv.luruidi.service.ScoreService;
import priv.luruidi.service.UserService;
import priv.luruidi.util.Page;

/**
 * @author 卢瑞迪
 * @date 2017年11月28日 上午11:44:21
 * @version V1.0
 * @Description TODO
 */
@Controller
@RequestMapping("/UserController")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private UserDao userDao;
	@Resource
	private ScoreService scoreService;
	@Resource
	private ResourceService resourceService;
	@RequestMapping("/register")
	public ModelAndView register(MultipartFile headImage,User user) throws Exception{
		String oldName = headImage.getOriginalFilename();
		String newName=new Date().getTime()+oldName;
		File file=new File("E:/upload/headImage",newName);
		if(!file.exists()){
			file.mkdirs();
		}
		headImage.transferTo(file);
		user.setImage(newName);
		Map<String, String> map = userService.saveUser(user);
		//通过用户注册的Id查找到该用户，初始化几分（30分）
		User u = userDao.queryByName(user.getName());
		Score score =new Score();
		score.setUserid(u.getId());
		score.setScore(30);
		score.setScoredate(new Date());
		score.setScoresource("注册用户");
		scoreService.saveScoreByUserid(score);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("flag", map.get("flag"));
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(String name,String password,HttpServletResponse response,HttpSession session) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		Map<String, Object> map = userService.login(name, password);
		if(map.get("flag").equals("failed")){
			modelAndView.addObject("mes", map.get("mes"));
			modelAndView.addObject("flag", "success");
			Integer totalCount= resourceService.queryResourceCount();
			//创建分页对象
			Page page=new Page(totalCount,1,5);
			List<Map<String, Object>> resourceList = resourceService.queryResource(page);
			modelAndView.addObject("resourceList", resourceList);
			modelAndView.addObject("page", page);
		}else{
			session.setAttribute("user", map.get("user"));
			response.sendRedirect("../ResourceController/queryResource.action?currentPage=1");
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/rexName")
	public @ResponseBody boolean rexName(String name){
		User user = userDao.queryByName(name);
		boolean flag=false;
		if(user!=null){
			flag=true;
		}
		return flag;
	}
	
	@RequestMapping("/logout")
	public void logout(HttpSession session,HttpServletResponse response) throws Exception{
		session.removeAttribute("user");
		response.sendRedirect("../ResourceController/queryResource.action?currentPage=1");
	}
	
	@RequestMapping("/queryMyself")
	public ModelAndView queryMyself(Integer userid){
		ModelAndView modelAndView=new ModelAndView();
		Map<String, Object> map = userService.queryMyself(userid);
		modelAndView.addObject("map", map);
		modelAndView.setViewName("personal");
		return modelAndView;
	}
	
}
