package com.login.service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.login.entity.SignUp;
/**
 * @describe SignUpService单元测试
 * @author pyq
 * 2018年3月16日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-dao.xml", "classpath:application-service.xml"})
public class SignUpServiceTest {

	@Autowired
	private SignUpService signUpService;
	
	@Test
	public void testLogin() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", "loginTest");
		map.put("password","testPassword");
		SignUp user = signUpService.login(map);
		System.out.println(user.getSignUpID());
	}

	@Test
	public void testRegist() {
		SignUp user = new SignUp();
		user.setLoginName("loginTest");
		user.setName("testName");
		user.setPassword("testPassword");
		user.setSignUpDateTime(new Date());
		signUpService.regist(user);
	}

}
