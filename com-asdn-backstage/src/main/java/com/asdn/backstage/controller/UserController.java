package com.asdn.backstage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asdn.backstage.mapper.UserMapper;
import com.asdn.backstage.pojo.Article;
import com.asdn.backstage.pojo.User;
import com.asdn.common.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class UserController {

	@Autowired
	private UserMapper usermapper;
	
	/**
	 * 根据用户id查询用户
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("/user/findByuserId/{id}")
	public String queryById(@PathVariable String id) throws JsonProcessingException{
		
		return ObjectUtil.mapper.writeValueAsString(usermapper.findByuserId(id));

	}
	@RequestMapping("/user/findByuserName/{userName}")
	public String queryByName(@PathVariable String userName) throws JsonProcessingException{
	String userJson = 	ObjectUtil.mapper.writeValueAsString(usermapper.findByuserName(userName));
		return userJson;
	}
	
	
	@RequestMapping("/user/findArticleByUserId/{userId}")
	public String queryArticleByUserId(@PathVariable String userId) throws JsonProcessingException{
		List<Article> artilceList = usermapper.findArticleByUserId1(userId);
		return ObjectUtil.mapper.writeValueAsString(artilceList);
	}
	
	
	@RequestMapping("/deleteMycollect/{userId}/{articleId}")
	public void deleteMycollect(@PathVariable String userId,@PathVariable String articleId){
		usermapper.deleteMyCollect(userId,articleId);
	}
	
	/**
	 * 根据用户name查询用户
	 */
	
	/**
	 * 根据浏览总量查询用户
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("user/findByHot")
	public List<User> findByHot() throws JsonProcessingException{
		List<User> userId = usermapper.findByHot1();
		List<User> users = new ArrayList<>();
		List<User> userss = new ArrayList<>();
		//获取用户信息
		for(int i=0;userId.size()>i;i++){
			User user=usermapper.findByHot4(userId.get(i).getUserId());
			users.add(i, user);
		}
		
		for(int x=0;userId.size()>x;x++){			
			int likes=0;
			List<Article> articleId = usermapper.findByHot2(userId.get(x).getUserId());
			for(int y=0;articleId.size()>y;y++){
				Integer articleLike = usermapper.findByHot3(articleId.get(y).getArticleId());
				likes+=articleLike;				
			}
			
				users.get(x).setUserLikes(likes);
			
			
			
//			users.set(x, userId.get(x));	
		}
		User s;
		for(int x=users.size()-1;x>=0;x--){
			for(int y=0;x>y;y++){
				if(users.get(y).getUserLikes()<users.get(x).getUserLikes()){
					s=users.get(y);
					users.set(y,users.get(x));
					users.set(x,s);
				}
			}
			
		}
//		String userJson=ObjectUtil.mapper.writeValueAsString(userIds);
		
		for(int i=0;i<6;i++){
			userss.add(users.get(i));
		}
		
		return userss;
	}
	
	@RequestMapping("/findArticleByTime/{userId}")
	public List<Article> findArticleByTime(@PathVariable String userId){
//		List<String> articleIdList = usermapper.findArticleIdByUserId(userId);
		List<Article> articleList = usermapper.findArticleByTime(userId);
		for (Article article : articleList) {
			String time = article.getArticleData().substring(0, 16);
			article.setArticleData(time);
		}
		return articleList;
	}
	
	@RequestMapping("/saveArticle/{articleId}/{userId}")
	public String saveArticle(@PathVariable String articleId,@PathVariable String userId){
		return usermapper.saveArticle(articleId,userId)+"";
	}
	@RequestMapping("/isSave/{userId}/{articleId}")
	public String isSave(@PathVariable String userId,@PathVariable String articleId){
		String articleId2 = usermapper.isSave(userId,articleId);
		if(articleId2!=null){
			return 1+"";
		}
		return 0+"";
	}
	
	@RequestMapping("/getMyCollect/{userId}")
	public List<Article> getMyCollectArticle(@PathVariable String userId){
//		List<String> articleIdList = usermapper.findArticleIdByUserId(userId);
		List<Article> articleList = usermapper.getMyCollectArticle(userId);
		for (Article article : articleList) {
			User user = usermapper.findUserByArticleId(article.getArticleId());
			String time = article.getArticleData().substring(0, 16);
			article.setUserName(user.getUserName());
			article.setUserImage(user.getUserImage());
			article.setArticleData(time);
		}
		return articleList;
	}
	
}
