package com.asdn.article.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asdn.article.mapper.ArticleMapper;
import com.asdn.article.mapper.CommentMapper;
import com.asdn.article.pojo.Article;
import com.asdn.article.pojo.User;
import com.asdn.common.util.ObjectUtil;
import com.asdn.common.vo.Page;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ArticleController {
	@Autowired
	private ArticleMapper articleMapper;
	/*
	 * 向用户和文章的关联表添加数据
	 */
	@RequestMapping("/article/saveArticle")
	public String saveArticle(@RequestBody String articleJson) throws Exception{
		Article article = ObjectUtil.mapper.readValue(articleJson, Article.class);
		return articleMapper.saveArticle(article)+"";
	}
	
	@RequestMapping("/article/saveUserIdAndArtiId/{userId}/{articleId}")
	public String saveUserIdAndArticleId(@PathVariable String userId,@PathVariable String articleId){

		return articleMapper.saveUserIdAndArticleId(userId,articleId)+"";
	}
	//"http://article.asdn.com/article/queryarticle?page="+currentPage+"&rows="+pageTotal;
	//分页查询数据
	@RequestMapping("/article/queryarticle")
	public List<Article> queryList(Integer page,Integer rows){
		//判断page是否为空
		if(page==null){page=1;}
		int start=(page-1)*rows;
		List<Article> listArticle = articleMapper.queryarticle(start,rows);
		for (Article article : listArticle) {
			String userId = articleMapper.findUserIdByArticleId(article.getArticleId());
			User user = articleMapper.findUserByArticleId(userId);
			article.setUserName(user.getUserName());
			article.setUserImage(user.getUserImage());
			article.setArticleData(article.getArticleData().substring(0, 16));
		}
		return listArticle;
	}
	@RequestMapping("/article/queryarticle2")
	public List<Article> queryList2(Integer page,Integer rows,String userId){
		//判断page是否为空
		if(page==null){page=1;}
		int start=(page-1)*rows;
		List<Article> listArticle = articleMapper.queryarticle2(start,rows,userId);
		User user = articleMapper.findUser(userId);
		for (Article article : listArticle) {
			article.setUserName(user.getUserName());
			article.setUserImage(user.getUserImage());
			article.setArticleData(article.getArticleData().substring(0, 16));
		}
		return listArticle;
	}
//	String url="http://article.asdn.com/article/total";
	//查询商品总数
	@RequestMapping("/article/total")
	public String queryTotal(){
		String total=articleMapper.queryCount()+"";
		return total;
	}
	
	@RequestMapping("/queryPage/{currentPage}/{totalPage}")
	public String queryPage(@PathVariable Integer currentPage,@PathVariable Integer totalPage) throws JsonProcessingException{
		int totalArticles = articleMapper.queryArticlePages(currentPage,totalPage);
		Page p = new Page();
		p.setCurrentPage(1);
		p.setTotalPage((totalArticles%5==0?(totalArticles/5):((totalArticles/5)+1)));
		String pageJson = ObjectUtil.mapper.writeValueAsString(p);
		return pageJson;
	}
	
	
	
	@RequestMapping("/findArticle/{articleId}")
	public String findArticle(@PathVariable String articleId) throws Exception{
		Article a= articleMapper.findArticleById(articleId);
		User user=articleMapper.findUser(articleId);
		a.setUserName(user.getUserName());
		a.setUserImage(user.getUserImage());
		return ObjectUtil.mapper.writeValueAsString(a);
	}
	@RequestMapping("/findUser/{articleId}")
	public String findUser(@PathVariable String articleId) throws Exception{
		User user=articleMapper.findUser(articleId);
		String userJson = ObjectUtil.mapper.writeValueAsString(user);
		return userJson;
		
	}
	
	@RequestMapping("/article/findarticleById/{articleId}")
	public String findArticleById(@PathVariable String articleId) throws JsonProcessingException{
		return ObjectUtil.mapper.writeValueAsString(articleMapper.findArticleByArticleId(articleId));
	}
	
	
	@RequestMapping("/article/queryArticleType")
	public List<Article> queryType(String articleType,Integer page,Integer rows){
		if(page==null){
			page=1;
		}
		int start=(page-1)*rows;
		List<Article> listArticle = articleMapper.queryArticleType(articleType,page,rows);
		for (Article article : listArticle) {
			String userId = articleMapper.findUserIdByArticleId(article.getArticleId());
			User user = articleMapper.findUserByArticleId(userId);
			article.setUserName(user.getUserName());
			article.setUserImage(user.getUserImage());
			article.setArticleData(article.getArticleData().substring(0, 16));
		}
		return listArticle;
	}
	
	@RequestMapping("/article/queryTotalPageByType/{articleType}")
	public String queryTotalPageByType(@PathVariable String articleType){
		return articleMapper.queryPageByType(articleType)+"";
	}
	
	
	@RequestMapping("/article/queryHot")
	public List<Article> queryHot(){
		
		List<Article> aList = articleMapper.queryHot();
		for (Article article : aList) {
			String userId = articleMapper.findUserIdByArticleId(article.getArticleId());
			User user = articleMapper.findUserByArticleId(userId);
			article.setUserName(user.getUserName());
		}
		return aList;
	}
	
	@RequestMapping("/article/deleteArticle/{articleId}")
	public void deleteArticle(@PathVariable String articleId){
		
		articleMapper.deleteArticle(articleId);
		articleMapper.deleteUserArticle(articleId);
	}
	
}
