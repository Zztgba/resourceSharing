package priv.luruidi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import priv.luruidi.bean.Collect;
import priv.luruidi.bean.User;
import priv.luruidi.service.CollectService;
import priv.luruidi.util.Page;

@Controller
@RequestMapping("/CollectController")
public class CollectController {
	@Resource
	private CollectService collectService;
	@RequestMapping("/saveCollect")
	@ResponseBody
	public Map<String,Object> saveCollect(Integer resourceid,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		User user = (User) session.getAttribute("user");
		Integer userid=user.getId();
		Integer countResource = collectService.countResource(userid, resourceid);
		if(countResource>0){
			map.put("flag", false);
			map.put("mes", "您已收藏过该资源,请到我的收藏栏目查看！");
			return map;
		}
		Collect collect=new Collect();
		collect.setUserid(userid);
		collect.setResourceid(resourceid);
		collect.setCollecttime(new Date());
		Integer count = collectService.saveCollect(collect);
		if(count==1){
			map.put("flag", true);
			map.put("mes", "资源收藏成功,请到我的收藏栏目查看！");
			return map;
		}
		map.put("flag", false);
		map.put("mes", "服务器异常,收藏失败！");
		return map;
	}
	@RequestMapping("/queryCollectList")
	public ModelAndView queryCollectList(HttpSession session,Integer currentPage){
		if(currentPage==null){
			currentPage=1;
		}
		User user = (User) session.getAttribute("user");
		Integer  totalCount= collectService.queryCollectListCount(user.getId());
		Page page=new Page(totalCount,currentPage,5);
		ModelAndView modelAndView=new ModelAndView();
		List<Map<String, String>> list = collectService.queryCollectList(user.getId(),page);
		modelAndView.addObject("collectList", list);
		modelAndView.addObject("page",page);
		modelAndView.setViewName("shoucang");
		return modelAndView;
	}
}
