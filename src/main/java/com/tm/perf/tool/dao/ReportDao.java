package com.tm.perf.tool.dao;

import java.util.List;

import com.tm.perf.tool.api.request.ReportRequest;
import com.tm.perf.tool.api.request.ReviewReport;

public interface ReportDao {
	List<ReviewReport> getReviewReport(ReportRequest request);
}
