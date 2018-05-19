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

import priv.luruidi.bean.Score;
import priv.luruidi.bean.User;
import priv.luruidi.dao.ResourceDao;
import priv.luruidi.dao.ScoreDao;
import priv.luruidi.service.ResourceService;
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
	@Resource
    private ResourceService resourceService;
	@Resource
    private ScoreDao scoreDao;
	@Resource
    private ResourceDao resourceDao;
	@RequestMapping("/queryScoreByUserid")
	public ModelAndView queryScoreByUserid(Integer userid){
		ModelAndView modelAndView=new ModelAndView();
		List<Score> scoreList = scoreService.queryScoreByUserid(userid);
		modelAndView.addObject("scoreList", scoreList);
		modelAndView.setViewName("point");
		return modelAndView;
	}
	@RequestMapping("/regScore")
    @ResponseBody
	public Map<String,Object> regScore(Integer resourceid, HttpSession session){
        priv.luruidi.bean.Resource resource = resourceService.resourceDetail(resourceid);
        User user = (User) session.getAttribute("user");
        Integer score = scoreDao.queryCountScoreByUserid(user);
        Map<String,Object> map=new HashMap<>();
        if((score-resource.getScore()>=0)){
            Score score1 = new Score();
            score1.setUserid(user.getId());
            score1.setScore(-resource.getScore());
            score1.setScoredate(new Date());
            score1.setScoresource("下载名字为"+resource.getName()+"的资源");
            Integer count = scoreDao.saveScoreByUserid(score1);
            resource.setDownloadTimes(resource.getDownloadTimes()+1);
            int i = resourceDao.updateResourceById(resource);
            if(count==1&&i==1){
                map.put("flag",true);
                return map;
            }
        }
        map.put("flag",false);
        map.put("mes","您只有"+score+"积分，不能下载此资源！");
        return map;
    }
}
