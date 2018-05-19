package priv.luruidi.dao;

import java.util.List;
import java.util.Map;

import priv.luruidi.bean.Comment;


public interface CommentDao {
	List<Map<String,String>> queryComments(Integer resourceId);
	Integer saveComment(Comment comment);
	Integer countCommentsByResourceIdAndUserId(Integer resourceId, Integer userId);
	Integer queryAvgStar(Integer resourceid);
}
