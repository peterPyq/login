package com.login.service;

import java.util.Map;

import com.login.entity.SignUp;

public interface ISignUpService {
	//用户注册  
	public int regist(SignUp user); 
    
    //用户登录  
    public SignUp login(Map<String,String> map);
}
