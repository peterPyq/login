package com.login.dao;

import java.util.Map;

import com.login.entity.SignUp;

public interface ISignUpDao {
	public SignUp getSignUp(Map<String,String> map);//登录查询
	public int addSignUp(SignUp user);//注册
}
