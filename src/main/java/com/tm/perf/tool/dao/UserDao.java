package com.tm.perf.tool.dao;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.request.ReviewReport;
import com.tm.perf.tool.api.response.CreateUserResponse;

/* 
 * 
 */
public interface UserDao {
	ReviewReport getReviewReport();
	
	public CreateUserResponse loginUser(LoginRequest loginRequest);
}
