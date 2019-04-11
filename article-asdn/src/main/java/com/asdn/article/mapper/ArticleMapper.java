package com.asdn.article.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asdn.article.pojo.Article;
import com.asdn.article.pojo.User;

public interface ArticleMapper {
	/**
	 * 向文章表中添加文章的方法
	 * @param article
	 * @return
	 */

	public int saveArticle(Article article) ;
	/**
	 * 
	 * @param userId
	 * @param articleId
	 * @return
	 */

	public int saveUserIdAndArticleId(@Param("userId") String userId,@Param(value="articleId") String articleId);
	/**
	 * 分页查询文章
	 * @param start
	 * @param rows
	 * @return
	 */
	public List<Article> queryarticle(@Param("start")int start,@Param("rows")Integer rows);
	/**
	 * 文章总数查询
	 * @return
	 */
	public int queryCount();
	
	public String findUserIdByArticleId(String articleId);
	public User findUserByArticleId(String userId);
	public int queryArticlePages(Integer currentPage, Integer totalPage);
	public Article findArticleById(String articleId);
	public String findId(String articleId);
	public User findUser(@Param("articleId") String articleId);
	public Article findArticleByArticleId(String articleId);
	public List<Article> queryarticle2(int start, Integer rows, String userId);
	public List<String> articleByUserId();
	
	
	List<Article> queryHot();
	
	int deleteArticle(String articleId);
	int deleteUserArticle(String articleId);
	
	public List<Article> queryArticleType(@Param("articleType")String articleType,@Param("start")int start,@Param("rows")Integer rows);
	public int queryPageByType(@Param("articleType") String articleType);
}
