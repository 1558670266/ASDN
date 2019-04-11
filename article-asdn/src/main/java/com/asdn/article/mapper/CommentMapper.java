package com.asdn.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asdn.article.pojo.Comment;
import com.asdn.article.pojo.User;

public interface CommentMapper {


	int saveComment(Comment comment);
	
	int saveCommAndArticle(@Param("articleId") String articleId,@Param("commentId") String commentId);

	List<String> getCommentId(@Param("articleId") String articleId);
	
	Comment getComment(@Param("commentId") String commentId);
	
	User getUserInfo(@Param("userId") String userId);

	int  saveZan(@Param("articleId") String articleId,@Param("likes") int likes);

	int getArticleLike(@Param("articleId") String articleId);

	


}
