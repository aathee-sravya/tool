package com.tm.perf.tool.dao;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.request.UserInfoRequest;
import com.tm.perf.tool.api.response.LoginResponse;
import com.tm.perf.tool.api.response.UserInfoResponse;

/* 
 * 
 */
public interface UserDao {
	
	public LoginResponse loginUser(LoginRequest loginRequest);
	
	public UserInfoResponse getUserInfo(UserInfoRequest createUserReq);
}
