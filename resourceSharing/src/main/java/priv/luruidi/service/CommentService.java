package priv.luruidi.service;

import java.util.List;
import java.util.Map;

import priv.luruidi.bean.Comment;


public interface CommentService {
	List<Map<String,String>> queryComments(Integer resoureceId);
	Integer saveComment(Comment comment);
	Integer countCommentsByResourceIdAndUserId(Integer resourceid, Integer userid);
}
