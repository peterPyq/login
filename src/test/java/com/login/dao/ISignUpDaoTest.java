package com.login.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.login.entity.SignUp;
/**
 * @describe SignUpDao单元测试类
 * @author pyq
 * 2018年3月16日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-dao.xml"})
public class ISignUpDaoTest {
	@Resource
	private ISignUpDao signUpDao;
	
	@Test
	public void testGetSignUp() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", "loginTest");
		map.put("password","testPassword");
		SignUp user = signUpDao.getSignUp(map);
		System.out.println(user.getSignUpID());
	}

	@Test
	public void testAddSignUp() {
		SignUp user = new SignUp();
		user.setLoginName("loginTest");
		user.setName("testName");
		user.setPassword("testPassword");
		user.setSignUpDateTime(new Date());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//		user.setSignUpDateTime(sdf.format(new Date()));
		signUpDao.addSignUp(user);
		
	}

}
