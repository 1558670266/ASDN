package com.asdn.common.vo;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	private Integer currentPage;
	private Integer totalPage;
	private List<?> articles;
	private List<?> users;
	private List<?> hortArticle;
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getArticles() {
		return articles;
	}
	public void setArticles(List<?> articles) {
		this.articles = articles;
	}
	public List<?> getUsers() {
		return users;
	}
	public void setUsers(List<?> users) {
		this.users = users;
	}
	public List<?> getHortArticle() {
		return hortArticle;
	}
	public void setHortArticle(List<?> hortArticle) {
		this.hortArticle = hortArticle;
	}
	
	
	
}
