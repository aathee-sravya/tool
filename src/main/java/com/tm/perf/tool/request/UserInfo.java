package com.tm.perf.tool.request;

import java.sql.Date;

/**
 * @author sandeepa
 *
 */
public class UserInfo {
	private int id;
	private String userUniqueId;
	private String emailId;
	private String mobileNumber;
	private String userName;
	private String password;
	private String designation;
	private String team;
	private String agent;
	private Date createTime;
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserUniqueId() {
		return userUniqueId;
	}

	public void setUserUniqueId(String userUniqueId) {
		this.userUniqueId = userUniqueId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userUniqueId=" + userUniqueId + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", userName=" + userName + ", password=" + password + ", designation=" + designation
				+ ", team=" + team + ", agent=" + agent + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
}
