package com.tm.perf.tool.dao;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.response.LoginResponse;

/* 
 * 
 */
public interface UserDao {
	
	public LoginResponse loginUser(LoginRequest loginRequest);
}
