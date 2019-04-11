package com.asdn.backstage.pojo;

import java.io.Serializable;

public class User implements Serializable{
/*	
 * user_id        VARCHAR(50)   utf8_general_ci  NO      PRI     (NULL)           SELECT,INSERT,UPDATE,REFERENCES         
	user_name      VARCHAR(20)   utf8_general_ci  YES             (NULL)           SELECT,INSERT,UPDATE,REFERENCES         
	user_password  INT(11)       (NULL)           YES             (NULL)           SELECT,INSERT,UPDATE,REFERENCES         
	user_realname  VARCHAR(20)   utf8_general_ci  YES             (NULL)           SELECT,INSERT,UPDATE,REFERENCES         
	user_email     VARCHAR(50)   utf8_general_ci  YES             (NULL)           SELECT,INSERT,UPDATE,REFERENCES         
	user_image     VARCHAR(100)  utf8_general_ci  YES             wqw.jpg          SELECT,INSERT,UPDATE,REFERENCES         
	user_phone     INT(11)       (NULL)           YES             (NULL)           SELECT,INSERT,UPDATE,REFERENCES         
	user_power     INT(11)       (NULL)           YES             0                SELECT,INSERT,UPDATE,REFERENCES         
*/
	private String userId;
	private String userName;
	private String userPassword;
	private String userRealname;
	private String userEmail;
	private String userImage;
	private String userPhone;
	private Integer userLikes;
	
	public Integer getUserLikes() {
		return userLikes;
	}
	public void setUserLikes(Integer userLikes) {
		this.userLikes = userLikes;
	}
	//用户权限
	private Integer userPower;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRealname() {
		return userRealname;
	}
	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Integer getUserPower() {
		return userPower;
	}
	public void setUserPower(Integer userPower) {
		this.userPower = userPower;
	}
	

}
