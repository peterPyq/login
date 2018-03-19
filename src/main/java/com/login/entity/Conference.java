package com.login.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Conference {
//	private int ConferenceID;//主键
	private BigDecimal conferenceID;//主键
	private String conferenceName;//会议名称
	private String chineseConferenceLocation;//会议地点
	private String conferenceType;//会议类型
	private Date conferenceBeginningDateTime;//会议开始时间
	private Date conferenceEndingDateTime;//会议结束时间
	private Date createdDateTime;//创建时间
	private BigDecimal signUpID;//会议提交人的注册ID
	public BigDecimal getConferenceID() {
		return conferenceID;
	}
	public void setConferenceID(BigDecimal conferenceID) {
		this.conferenceID = conferenceID;
	}
	public String getConferenceName() {
		return conferenceName;
	}
	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}
	public String getChineseConferenceLocation() {
		return chineseConferenceLocation;
	}
	public void setChineseConferenceLocation(String chineseConferenceLocation) {
		this.chineseConferenceLocation = chineseConferenceLocation;
	}
	public String getConferenceType() {
		return conferenceType;
	}
	public void setConferenceType(String conferenceType) {
		this.conferenceType = conferenceType;
	}
	public Date getConferenceBeginningDateTime() {
		return conferenceBeginningDateTime;
	}
	public void setConferenceBeginningDateTime(Date conferenceBeginningDateTime) {
		this.conferenceBeginningDateTime = conferenceBeginningDateTime;
	}
	public Date getConferenceEndingDateTime() {
		return conferenceEndingDateTime;
	}
	public void setConferenceEndingDateTime(Date conferenceEndingDateTime) {
		this.conferenceEndingDateTime = conferenceEndingDateTime;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public BigDecimal getSignUpID() {
		return signUpID;
	}
	public void setSignUpID(BigDecimal signUpID) {
		this.signUpID = signUpID;
	}
	
	
}
