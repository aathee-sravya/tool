package com.tm.perf.tool.api.request.config;

public class UserInfo {
	private String uniqueId;
	private String emailId;
	private String mobileNumber;
	private String userName;
	private String designation;
	private String team;
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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
	@Override
	public String toString() {
		return "UserInfo [uniqueId=" + uniqueId + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ ", userName=" + userName + ", designation=" + designation + ", team=" + team + "]";
	}

	
}
