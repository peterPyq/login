package com.login.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.login.entity.Conference;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-dao.xml"})
public class IConferenceDaoTest {

	@Resource
	private IConferenceDao conferenceDao;
	
	@Test
	public void testDeleteByPrimaryKey() {
		conferenceDao.deleteByPrimaryKey(new BigDecimal(100));
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Conference conference = new Conference();
		conference.setConferenceName("UPDATE测试会议名");
		conference.setConferenceID(new BigDecimal(100));
		conferenceDao.updateByPrimaryKey(conference);
	}

	@Test
	public void testInsert() {
		Conference conference = new Conference();
		conference.setConferenceName("ConferenceName4");
		conference.setChineseConferenceLocation("shanghai");
		conference.setConferenceBeginningDateTime(new Date());
		conference.setConferenceEndingDateTime(new Date());
		conference.setConferenceType("math");
		conference.setCreatedDateTime(new Date());
		conference.setSignUpID(new BigDecimal(101));
		conferenceDao.insert(conference);
	}

	@Test
	public void testSelectRecentConference() {
		Date date = new Date();
		Calendar cal =Calendar.getInstance();
		cal.add(cal.DATE, -1);
		date=cal.getTime();
		List<Conference> list =conferenceDao.selectRecentConference(date);
		for(Conference conference:list) {
			System.out.println(conference.getConferenceID());
		}
	}

	@Test
	public void testSelectByType() {
		List<Conference> list =conferenceDao.selectByType("ConferenceType测试类别");
		for(Conference conference:list) {
			System.out.println(conference.getConferenceID());
		}
	}

}
