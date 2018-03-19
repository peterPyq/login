package com.login.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SignUp {
	
//	private int signUpID;//主键
	private BigDecimal signUpID;//主键
	private String loginName;//登录名 
	private String password;//密码
	private String name;//姓名
//	private String signUpDateTime;//注册时间
	private Date signUpDateTime;//注册时间
	
//	public int getSignUpID() {
//		return signUpID;
//	}
//	public void setSignUpID(int signUpID) {
//		this.signUpID = signUpID;
//	}
	public BigDecimal getSignUpID() {
		return signUpID;
	}
	public void setSignUpID(BigDecimal signUpID) {
		this.signUpID = signUpID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getSignUpDateTime() {
//		return signUpDateTime;
//	}
//	public void setSignUpDateTime(String signUpDateTime) {
//		this.signUpDateTime = signUpDateTime;
//	}
	public Date getSignUpDateTime() {
		return signUpDateTime;
	}
	public void setSignUpDateTime(Date signUpDateTime) {
		this.signUpDateTime = signUpDateTime;
	}
	
}
