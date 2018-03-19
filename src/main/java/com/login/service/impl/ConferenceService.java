package com.login.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.login.dao.IConferenceDao;
import com.login.entity.Conference;
import com.login.service.IConferenceService;
@Service
public class ConferenceService implements IConferenceService {
	
	@Resource
	private IConferenceDao conferenceDao;
	
	@Override
	public int doDelete(BigDecimal conferenceID) {
		return conferenceDao.deleteByPrimaryKey(conferenceID);
	}

	@Override
	public int doUpdate(Conference conference) {
		return conferenceDao.updateByPrimaryKey(conference);
	}

	@Override
	public int doInsert(Conference conference) {
		return conferenceDao.insert(conference);
	}

	@Override
	public List<Conference> recentConference(Date recentDate) {
		return conferenceDao.selectRecentConference(recentDate);
	}

	@Override
	public List<Conference> typeOfConference(String conferenceType) {
		return conferenceDao.selectByType(conferenceType);
	}

	@Override
	public Conference selectByPrimaryKey(BigDecimal conferenceID) {
		return conferenceDao.selectByPrimaryKey(conferenceID);
	}

	@Override
	public List<Conference> selectByLocaltion(String chineseConferenceLocation) {
		return conferenceDao.selectByLocaltion(chineseConferenceLocation);
	}

	@Override
	public List<Conference> selectByName(String conferenceName) {
		return conferenceDao.selectByName(conferenceName);
	}
}
