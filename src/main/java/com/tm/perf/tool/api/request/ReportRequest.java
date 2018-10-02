package com.tm.perf.tool.api.request;

import java.util.Date;

public class ReportRequest {
	private int companyId;
	private int userId;
	private Date fromDate;
	private Date toDate;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "ReportRequest [companyId=" + companyId + ", userId=" + userId + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}

}
