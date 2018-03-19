package com.login.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.login.entity.Conference;

public interface IConferenceService {
	public int doDelete(BigDecimal conferenceID);//会议表的删除操作
	public int doUpdate(Conference conference);//会议表的更新操作
	public int doInsert(Conference conference);//会议表的插入操作
	
	public List<Conference> recentConference(Date recentDate);//查询最近的会议
	
	public List<Conference> typeOfConference(String conferenceType);//查询某个类型的会议
	
	public Conference selectByPrimaryKey(BigDecimal conferenceID);//根据主键查询
	
	public List<Conference> selectByLocaltion(String chineseConferenceLocation);//根据ChineseConferenceLocation模糊查询
	
	public List<Conference> selectByName(String conferenceName);//根据ConferenceName模糊查询
	
}
