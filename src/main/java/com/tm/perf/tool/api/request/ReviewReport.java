package com.tm.perf.tool.api.request;

import java.sql.Date;

/**
 * @author sandeepa
 * @Description performance report of user or employee
 */
public class ReviewReport {
	private int id;
	private int companyId;
	private int userId;
	private String designation;
	private int managerId;
	private String subConfigurationName;
	private int actualPoints;
	private int receivedPoints;
	private Date fromDate;
	private Date toDate;
	private String agent;
	private Date createdAt;
	private Date updatedAt;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getSubConfigurationName() {
		return subConfigurationName;
	}
	public void setSubConfigurationName(String subConfigurationName) {
		this.subConfigurationName = subConfigurationName;
	}
	public int getActualPoints() {
		return actualPoints;
	}
	public void setActualPoints(int actualPoints) {
		this.actualPoints = actualPoints;
	}
	public int getReceivedPoints() {
		return receivedPoints;
	}
	public void setReceivedPoints(int receivedPoints) {
		this.receivedPoints = receivedPoints;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "ReviewReport [id=" + id + ", userId=" + userId + ", managerId=" + managerId + ", subConfigurationName="
				+ subConfigurationName + ", actualPoints=" + actualPoints + ", receivedPoints=" + receivedPoints
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", agent=" + agent + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
