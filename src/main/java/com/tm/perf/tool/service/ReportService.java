package com.tm.perf.tool.service;

import java.util.List;

import com.tm.perf.tool.api.request.ReportRequest;
import com.tm.perf.tool.api.request.ReviewReport;
import com.tm.perf.tool.api.response.UserResponse;


public interface ReportService {
	List<ReviewReport> getReviewReport(ReportRequest request);
	UserResponse listofUsers(int id);
}
