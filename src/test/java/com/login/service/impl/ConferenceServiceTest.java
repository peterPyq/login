package com.login.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.login.entity.Conference;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-dao.xml", "classpath:application-service.xml"})
public class ConferenceServiceTest {

	@Autowired
	private ConferenceService conferenceService;
	
	@Test
	public void testDoDelete() {
		conferenceService.doDelete(new BigDecimal(101));
	}

	@Test
	public void testDoUpdate() {
		Conference conference = new Conference();
		conference.setConferenceName("UPDATE测试会议名");
		conference.setConferenceID(new BigDecimal(102));
		conferenceService.doUpdate(conference);
	}

	@Test
	public void testDoInsert() {
		Conference conference = new Conference();
		
//		conference.setConferenceName("Test Name1");
//		conference.setChineseConferenceLocation("beijing");
//		conference.setConferenceBeginningDateTime(new Date());
//		conference.setConferenceEndingDateTime(new Date());
//		conference.setConferenceType("science");
//		conference.setCreatedDateTime(new Date());
//		conference.setSignUpID(new BigDecimal(100));
		
//		conference.setConferenceName("Test Name2");
//		conference.setChineseConferenceLocation("beijing");
//		conference.setConferenceBeginningDateTime(new Date());
//		conference.setConferenceEndingDateTime(new Date());
//		conference.setConferenceType("science");
//		conference.setCreatedDateTime(new Date());
//		conference.setSignUpID(new BigDecimal(101));
		
		
//		conference.setConferenceName("Test Name3");
//		conference.setChineseConferenceLocation("wuhan");
//		conference.setConferenceBeginningDateTime(new Date());
//		conference.setConferenceEndingDateTime(new Date());
//		conference.setConferenceType("biological");
//		conference.setCreatedDateTime(new Date());
//		conference.setSignUpID(new BigDecimal(100));
		
		conference.setConferenceName("Test Name4");
		conference.setChineseConferenceLocation("shanghai");
		conference.setConferenceBeginningDateTime(new Date());
		conference.setConferenceEndingDateTime(new Date());
		conference.setConferenceType("math");
		conference.setCreatedDateTime(new Date());
		conference.setSignUpID(new BigDecimal(100));
		
		conferenceService.doInsert(conference);
	}

	@Test
	public void testRecentConference() {
		Date date = new Date();
		Calendar cal =Calendar.getInstance();
		cal.add(cal.DATE, -1);
		date=cal.getTime();
		List<Conference> list =conferenceService.recentConference(date);
		for(Conference conference:list) {
			System.out.println(conference.getConferenceID());
		}
	}

	@Test
	public void testTypeOfConference() {
		List<Conference> list =conferenceService.typeOfConference("ConferenceType测试类别");
		for(Conference conference:list) {
			System.out.println(conference.getConferenceID());
		}
	}

}
