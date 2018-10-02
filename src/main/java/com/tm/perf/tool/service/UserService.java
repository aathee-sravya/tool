package com.tm.perf.tool.service;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.request.UserInfoRequest;
import com.tm.perf.tool.api.response.LoginResponse;
import com.tm.perf.tool.api.response.UserInfoResponse;

/* 
 * User Related operations go through this 
 * Basic are identified as
 *   1) Create User
 *   2) Get User Info/Profile
 */
public interface UserService {
	
	public LoginResponse loginUser(LoginRequest loginRequest);
	
	public UserInfoResponse getUserInfo(UserInfoRequest createUserReq);
}
