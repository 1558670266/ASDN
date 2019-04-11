package com.asdn.article.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asdn.article.mapper.CommentMapper;
import com.asdn.article.pojo.Comment;
import com.asdn.article.pojo.User;
import com.asdn.common.util.ObjectUtil;

@RestController
public class CommentController {
	@Autowired
	private CommentMapper commentMapper;

	@RequestMapping("/giveComment")
	public String giveComment(@RequestBody String commJson) throws Exception {
		Comment comment = ObjectUtil.mapper.readValue(commJson, Comment.class);
		int i = commentMapper.saveComment(comment);
		int success = commentMapper.saveCommAndArticle(comment.getArticleId(), comment.getCommentId());
		return success + "";
	}

	@RequestMapping("/getComment/{articleId}")
	public List<Comment> getComment(@PathVariable String articleId) {
		// 根据文章的id从关联表中获取该文章的所有评论的id，根据发表时间排序出来
		List<String> commentIdList = commentMapper.getCommentId(articleId);
		// 创建一个评论对象list集合
		List<Comment> commentList = new ArrayList<Comment>();
		for (int i = 0; i < commentIdList.size(); i++) {
			// 循环遍历集合
			// 循环遍历评论id的集合，从评论表中根据评论的id获取该评论的用户id
			Comment comment = commentMapper.getComment(commentIdList.get(i));
			User user = commentMapper.getUserInfo(comment.getCommentXuserid());
			comment.setCommentId(commentIdList.get(0));
			comment.setUserName(user.getUserName());
			comment.setUserImage(user.getUserImage());
			commentList.add(comment);
		}
		return commentList;

	}
	
	@RequestMapping("/dianZan/{articleId}")
	public String dianZan(@PathVariable String articleId){
		int likes = commentMapper.getArticleLike(articleId);
		return commentMapper.saveZan(articleId,likes+1)+"";
	}
}
