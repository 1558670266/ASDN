package com.asdn.article.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Article {
	// article_id VARCHAR(50) utf8_general_ci NO PRI (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES
	// article_abstract VARCHAR(200) utf8_general_ci YES (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES
	// article_content TEXT utf8_general_ci YES (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES
	// article_image VARCHAR(100) utf8_general_ci YES (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES
	// article_type VARCHAR(20) utf8_general_ci YES (NULL)
	// SELECT,INSERT,UPDATE,REFERENCES
	// article_data DATETIME (NULL) YES (NULL) SELECT,INSERT,UPDATE,REFERENCES
	// article_like INT(11) (NULL) YES (NULL) SELECT,INSERT,UPDATE,REFERENCES
	private String articleId;
	private String articleTitle;
	private String articleAbstract;
	private String articleContent;
	private String articleImage;
	private String articleType;
	private String articleData;
	private Integer articleLike;
	private String userName;
	private String userImage;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public Integer getArticleLike() {
		return articleLike;
	}

	public void setArticleLike(Integer articleLike) {
		this.articleLike = articleLike;
	}

	public String getArticleData() {
		return articleData;
	}

	public void setArticleData(String articleData) {
		this.articleData = articleData;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleAbstract=" + articleAbstract + ", articleContent="
				+ articleContent + ", articleImage=" + articleImage + ", articleType=" + articleType + ", articleData="
				+ articleData + ", articleLike=" + articleLike + "]";
	}
}
