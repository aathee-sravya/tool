package com.tm.perf.tool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tm.perf.tool.api.response.UserResponse;
import com.tm.perf.tool.dao.ReportDao;
import com.tm.perf.tool.api.request.ReportRequest;
import com.tm.perf.tool.api.request.ReviewReport;
import com.tm.perf.tool.service.ReportService;

public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao reportDao;
	
	@Override
	public List<ReviewReport> getReviewReport(ReportRequest request) {
		
		return reportDao.getReviewReport(request);
	}
	
	public UserResponse listofUsers(int id) {
		return null;
	}
}
