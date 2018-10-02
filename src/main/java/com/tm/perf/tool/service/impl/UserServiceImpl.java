package com.tm.perf.tool.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.request.UserInfoRequest;
import com.tm.perf.tool.api.response.LoginResponse;
import com.tm.perf.tool.api.response.UserInfoResponse;
import com.tm.perf.tool.dao.UserDao;
import com.tm.perf.tool.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userdao;
	
    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        return userdao.loginUser(loginRequest);
    }

    @Override
    public UserInfoResponse getUserInfo(UserInfoRequest createUserReq) {
        return userdao.getUserInfo(createUserReq);
    }

}
