package com.login.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.entity.ActionResult;
import com.login.entity.Conference;
import com.login.entity.SignUp;
import com.login.service.IConferenceService;
/**
 * @describe 会议信息的增删改查controller
 * @author pyq
 * 2018年3月16日
 */
@Controller
@RequestMapping("/conference")
public class ConferenceController {
	
	private static String SCIENCE_TYPE="science";
	private static String BIOLOGICAL_TYPE="biological";
	private static String MATH_TYPE="math";
	
	@Autowired
	private IConferenceService conferenceService;
	
	/**
	 * 会议信息展示
	 * @param SignUpID
	 * @return
	 */
	@RequestMapping("/listdata")	
	public String listData(HttpSession httpSession , ModelMap map) {
		SignUp user=(SignUp) httpSession.getAttribute("user");
		if(user==null) {
			return "login"; 
		}
		map.put("recenctConference", getRecentConference());
		map.put("scienceOfConference", typeOfConference(SCIENCE_TYPE));
		map.put("biologicalOfConference", typeOfConference(BIOLOGICAL_TYPE));
		map.put("mathOfConference", typeOfConference(MATH_TYPE));
		return "index";
	}
	
	/**
	 * 跳转到会议信息编辑页面
	 * @param conferenceID
	 * @return
	 */
	@RequestMapping("/{conferenceID}/edit")
	public String actForm(@PathVariable("conferenceID")BigDecimal conferenceID , ModelMap map) {
		Conference entity =conferenceService.selectByPrimaryKey(conferenceID);
		map.put("entity", entity);
		return "conferenceEdit";
	}
	
	/**
	 * 跳转到会议信息编辑页面，填写新会议信息
	 * @param conferenceType
	 * @return
	 */
	@RequestMapping("/addNew/{conferenceType}")
	public String actAdd(@PathVariable("conferenceType")String conferenceType , ModelMap map) {
		map.put("conferenceType", conferenceType);
		return "conferenceEdit";
	}
	
	/**
	 * 保存新增的会议信息
	 * @param Conference
	 * @return
	 */
//	@RequestMapping(value = "/insert",
//	method = RequestMethod.POST,
//	produces = {"application/json;charset=UTF-8" })
//	@ResponseBody
//	@Transactional
//	public ActionResult actInsert(HttpServletRequest req , @ModelAttribute("user")SignUp user) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.US);
//		
//		Conference conference = new Conference();
//		conference.setChineseConferenceLocation(req.getParameter("chineseConferenceLocation"));
//		conference.setConferenceBeginningDateTime(sdf.parse(req.getParameter("conferenceBeginningDateTime")));
//		conference.setConferenceEndingDateTime(sdf.parse(req.getParameter("conferenceEndingDateTime")));
//		conference.setConferenceName(req.getParameter("conferenceName"));
//		conference.setConferenceType(req.getParameter("conferenceType"));
//		conference.setCreatedDateTime(new Date());
//		conference.setSignUpID(user.getSignUpID());
//		
//		int ret = conferenceService.doInsert(conference);
//		if(ret==1) {
//			return new ActionResult(true, "NO Errors,Insert Success") ;
//		}else {
//			return new ActionResult(false, "Insert Errors") ;
//		}
//	}
	
	@RequestMapping(value = "/insert",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8" })
			@ResponseBody
			@Transactional
			public ActionResult actInsert(HttpServletRequest req , HttpSession httpSession) throws ParseException {
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.US);
				SignUp user=(SignUp) httpSession.getAttribute("user");
				System.out.println("+++++++++++"+user.getSignUpID());
				Conference conference = new Conference();
				conference.setChineseConferenceLocation(req.getParameter("chineseConferenceLocation"));
				conference.setConferenceBeginningDateTime(sdf.parse(req.getParameter("conferenceBeginningDateTime")));
				conference.setConferenceEndingDateTime(sdf.parse(req.getParameter("conferenceEndingDateTime")));
				conference.setConferenceName(req.getParameter("conferenceName"));
				conference.setConferenceType(req.getParameter("conferenceType"));
				conference.setCreatedDateTime(new Date());
				conference.setSignUpID(user.getSignUpID());
				
				int ret = conferenceService.doInsert(conference);
				if(ret==1) {
					return new ActionResult(true, "NO Errors,Insert Success") ;
				}else {
					return new ActionResult(false, "Insert Errors") ;
				}
			}
	
	/**
	 * 更新会议信息
	 * @param Conference
	 * @return
	 */
	@RequestMapping(value = "/{conferenceID}/update",
	method = RequestMethod.POST,
	produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	@Transactional
	public ActionResult actUpdate(HttpServletRequest req , @ModelAttribute("user")SignUp user) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.US);
		
		Conference conference = new Conference();
		conference.setChineseConferenceLocation(req.getParameter("chineseConferenceLocation"));
		conference.setConferenceBeginningDateTime(sdf.parse(req.getParameter("conferenceBeginningDateTime")));
		conference.setConferenceEndingDateTime(sdf.parse(req.getParameter("conferenceEndingDateTime")));
		conference.setConferenceName(req.getParameter("conferenceName"));
		conference.setConferenceType(req.getParameter("conferenceType"));
		conference.setCreatedDateTime(new Date());
		conference.setSignUpID(user.getSignUpID());
		conference.setConferenceID(new BigDecimal(req.getParameter("conferenceID")));
		int ret = conferenceService.doUpdate(conference);
		if(ret==1) {
			return new ActionResult(true, "NO Errors,Update Success");
		}else {
			return new ActionResult(false, "Update Errors") ;
		}
	}
	
	/**
	 * 删除对应的会议
	 * @param conferenceID
	 * @return
	 */
	@RequestMapping(value = "/{conferenceID}/delete",
	produces = {"application/json;charset=UTF-8" })
	@ResponseBody
	@Transactional
	public ActionResult actDelete(@PathVariable("conferenceID")BigDecimal conferenceID) {
		int ret = conferenceService.doDelete(conferenceID);
		if(ret==1) {
			return new ActionResult(true, "NO Errors,Delete Success");
		}else {
			return new ActionResult(false, "Delete Errors") ;
		}
	}
	
	
//	/**
//	 * 根据会议地点查询会议信息
//	 * @param chineseConferenceLocation
//	 * @return
//	 */
//	@RequestMapping(value = "/{chineseConferenceLocation}/findByLocation",
//	produces = {"application/json;charset=UTF-8" })
//	@ResponseBody
//	@Transactional
//	public ActionResult actSelectLocation(@PathVariable("chineseConferenceLocation")String chineseConferenceLocation) {
//		ActionResult<List<Conference>> result = null;
//		List<Conference> list = conferenceService.selectByLocaltion("%"+chineseConferenceLocation+"%");
//		result.setSuccess(true);
//		result.setData(list);
//		return result ;
//		
//	}
//	
//	/**
//	 * 根据ConferenceName模糊查询 
//	 * @param conferenceName
//	 * @return
//	 */
//	@RequestMapping(value = "/{conferenceName}/findByName",
//	produces = {"application/json;charset=UTF-8" })
//	@ResponseBody
//	@Transactional
//	public ActionResult actSelectName(@PathVariable("conferenceName")String conferenceName) {
//		ActionResult<List<Conference>> result = null;
//		List<Conference> list = conferenceService.selectByLocaltion("%"+conferenceName+"%");
//		result.setSuccess(true);
//		result.setData(list);
//		return result ;
//	}
	
	public List<Conference> getRecentConference() {
		Date date = new Date();
		Calendar cal =Calendar.getInstance();
		cal.add(cal.DATE, -1);
		date=cal.getTime();
		List<Conference> list = conferenceService.recentConference(date);
		return list;
	}
	
	public List<Conference> typeOfConference(String conferenceType) {
		List<Conference> list = conferenceService.typeOfConference(conferenceType);
		return list;
	}
}
