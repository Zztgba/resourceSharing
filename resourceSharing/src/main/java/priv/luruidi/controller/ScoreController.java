package priv.luruidi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.luruidi.bean.Score;
import priv.luruidi.service.ScoreService;

/**
 * @author 卢瑞迪
 * @date 2017年12月6日 下午4:10:07
 * @version V1.0
 * @Description TODO
 */
@Controller
@RequestMapping("/ScoreController")
public class ScoreController {
	@Resource 
	private ScoreService scoreService;
	@RequestMapping("/queryScoreByUserid")
	public ModelAndView queryScoreByUserid(Integer userid){
		ModelAndView modelAndView=new ModelAndView();
		List<Score> scoreList = scoreService.queryScoreByUserid(userid);
		modelAndView.addObject("scoreList", scoreList);
		modelAndView.setViewName("point");
		return modelAndView;
	}
}
