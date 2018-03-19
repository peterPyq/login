package com.login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.entity.SignUp;
import com.login.service.ISignUpService;
/**
 * @describe 用户登录
 * @author pyq
 * 2018年3月16日
 */
@SessionAttributes("user")
@Controller
@RequestMapping("/signUp")
public class SignUpController {
	@Autowired
	private ISignUpService signUpService;
	
	
	/**
	 * 用户登录验证
	 * @author pyq
	 * 2018年3月16日
	 */
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(HttpServletRequest req,Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", req.getParameter("loginName"));
		map.put("password", req.getParameter("password"));
		SignUp user = signUpService.login(map);
		if(null!=user) {
			model.addAttribute("user", user);
			return "forward:/conference/listdata";
		}
		model.addAttribute("message", "用户名或密码输入错误,请重新输入");
		return "login";
	}
	
	/**
	 * 用户跳转到注册页面
	 * @author pyq
	 * 2018年3月16日
	 */
	@RequestMapping(value="/regist" , method=RequestMethod.GET)
	public String regist() {
		return "signUpRegist";
	}
	
	/**
	 * 用户注册
	 * @author pyq
	 * 2018年3月16日
	 */
	@RequestMapping(value="/regist/submit" , method=RequestMethod.POST)
	public String submit(HttpServletRequest req,Model model) {
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");
		SignUp user;
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", loginName);
		map.put("password", password);
		user = signUpService.login(map);
		if(null!=user) {
			model.addAttribute("message", "用户已经存在，请重新注册");
			return "signUpRegist";
		}else {
			user = new SignUp();
			user.setLoginName(req.getParameter("loginName"));
			user.setName(req.getParameter("name"));
			user.setPassword(req.getParameter("password"));
			user.setSignUpDateTime(new Date());
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//			user.setSignUpDateTime(sdf.format(new Date()));
			int ret = signUpService.regist(user);
			if(1 == ret) {
				return "login";
			}else {
				model.addAttribute("message", "用户注册失败，请重新注册");
				return "signUpRegist";
			}
		}	
	}
}
