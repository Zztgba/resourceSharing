package priv.luruidi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import priv.luruidi.bean.Comment;
import priv.luruidi.bean.User;
import priv.luruidi.service.CommentService;

@RestController
@RequestMapping("/CommentController")
public class CommentController {
	@Resource
	private CommentService commentService;
	@RequestMapping("/saveComment")
	@ResponseBody
	public Map<String,Object> saveComment(Integer resourceId,String advice,Integer star,HttpSession session){
		//session中获取用户对象
		User user = (User) session.getAttribute("user");
		Integer userid = user.getId();
		Integer countComments = commentService.countCommentsByResourceIdAndUserId(resourceId, userid);
		Map<String,Object> map=new HashMap<>();
		if(countComments>0){
			map.put("flag", false);
			map.put("mes", "你已经评论过改资源，不能重复评论！");
			return map;
		}
		Comment comment=new Comment();
		comment.setContent(advice);
		comment.setStar(star);
		comment.setResourceid(resourceId);
		comment.setUserid(userid);
		comment.setCreateTime(new Date());
		Integer count = commentService.saveComment(comment);
		if(count==1){
			map.put("flag", true);
			return map;
		}
		map.put("flag", false);
		map.put("mes", "服务器异常,评论失败！");
		return map;
	}
}
