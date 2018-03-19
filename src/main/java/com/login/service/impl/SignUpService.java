package com.login.service.impl;

import java.util.Map;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.login.dao.ISignUpDao;
import com.login.entity.SignUp;
import com.login.service.ISignUpService;

@Service
public class SignUpService implements ISignUpService {
	@Resource
	private ISignUpDao signUpDao;
	
	@Override
	public int regist(SignUp user) {
		return signUpDao.addSignUp(user);
	}

	@Override
	public SignUp login(Map<String, String> map) {
		return signUpDao.getSignUp(map);
	}

}
