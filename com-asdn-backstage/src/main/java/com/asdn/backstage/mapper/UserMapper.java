package com.asdn.backstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.asdn.backstage.pojo.Article;
import com.asdn.backstage.pojo.User;

public interface UserMapper {

	User findByuserId(String userId);
	User findByuserName(String userId);

	List<User> findByHot1();
	List<Article> findByHot2(String userId);
	Integer findByHot3(String articleId);

	User findByHot4(String userId);

	List<String> findArticleIdByUserId(String userId);

//	List<Article> findArticleByTime(@Param("list") List<String> articleIdList);
	List<Article> findArticleByTime(@Param("userId") String userId);

	List<Article> findArticleByUserId1(String userId);
	Article findArticleByUserId2(String userid);
	int saveArticle(@Param("articleId")String articleId, @Param("userId") String userId);
	String isSave(@Param("userId") String userId, @Param("articleId") String articleId);
	List<Article> getMyCollectArticle(String userId);
	User findUserByArticleId(@PathVariable String articleId);
	int deleteMyCollect(@Param("userId") String userId,@Param("articleId") String articleId);
}
