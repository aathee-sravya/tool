package com.tm.perf.tool.request;

import java.sql.Date;

/**
 * @author sandeepa
 *
 */
public class UserProfile {
	private int userProfileId;
	private int userId;
	private String primaryEmail;
	private String officeEmail;
	private String primaryMobile;
	private String emergencyContact;
	private Date dateOfBirth;
	private String primaryAddress;
	private String permanentAddress;
	private String firstName;
	private String lastName;
	private Date signUpDate;
	private String agent;
	private String status;
	private Date createTime;
	private Date updateTime;

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getOfficeEmail() {
		return officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public String getPrimaryMobile() {
		return primaryMobile;
	}

	public void setPrimaryMobile(String primaryMobile) {
		this.primaryMobile = primaryMobile;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "UserProfile [userProfileId=" + userProfileId + ", userId=" + userId + ", primaryEmail=" + primaryEmail
				+ ", officeEmail=" + officeEmail + ", primaryMobile=" + primaryMobile + ", emergencyContact="
				+ emergencyContact + ", dateOfBirth=" + dateOfBirth + ", primaryAddress=" + primaryAddress
				+ ", permanentAddress=" + permanentAddress + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", signUpDate=" + signUpDate + ", agent=" + agent + ", status=" + status + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
}
