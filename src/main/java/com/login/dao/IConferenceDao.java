package com.login.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.login.entity.Conference;

public interface IConferenceDao {
	int deleteByPrimaryKey(BigDecimal conferenceID);
	int updateByPrimaryKey(Conference conference);
	int insert(Conference conference);
	
	List<Conference> selectRecentConference(Date recentDate);
	
	List<Conference> selectByType(String conferenceType);
	
	Conference selectByPrimaryKey(BigDecimal conferenceID);
	
	List<Conference> selectByLocaltion(String chineseConferenceLocation);
	List<Conference> selectByName(String conferenceName);
	
}
