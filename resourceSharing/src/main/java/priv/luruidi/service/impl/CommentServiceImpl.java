package priv.luruidi.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import priv.luruidi.bean.Comment;
import priv.luruidi.dao.CommentDao;
import priv.luruidi.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	@Resource
	private CommentDao commentDao;
	@Override
	public List<Map<String,String>> queryComments(Integer resourceId) {
		return commentDao.queryComments(resourceId);
	}
	@Override
	public Integer saveComment(Comment comment) {
		return commentDao.saveComment(comment);
	}
	@Override
	public Integer countCommentsByResourceIdAndUserId(Integer resourceid, Integer userid) {
		return commentDao.countCommentsByResourceIdAndUserId(resourceid, userid);
	}

}
