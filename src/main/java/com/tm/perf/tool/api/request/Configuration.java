package com.tm.perf.tool.api.request;

import java.sql.Date;

/**
 * @author sandeepa
 * configuration date for performance parameters
 */
public class Configuration {
	private int id;
	private String parameterName;
	private String subParamName;
	private String subParamDisplayName;
	private String agent;
	private Date createTime;
	private Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getSubParamName() {
		return subParamName;
	}
	public void setSubParamName(String subParamName) {
		this.subParamName = subParamName;
	}
	public String getSubParamDisplayName() {
		return subParamDisplayName;
	}
	public void setSubParamDisplayName(String subParamDisplayName) {
		this.subParamDisplayName = subParamDisplayName;
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
		return "Configuration [id=" + id + ", parameterName=" + parameterName + ", subParamName=" + subParamName
				+ ", subParamDisplayName=" + subParamDisplayName + ", agent=" + agent + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
}
