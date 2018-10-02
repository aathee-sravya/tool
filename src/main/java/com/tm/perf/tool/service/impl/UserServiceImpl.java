package com.tm.perf.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.response.LoginResponse;
import com.tm.perf.tool.dao.UserDao;
import com.tm.perf.tool.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserDao userdao;
	
    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        return userdao.loginUser(loginRequest);
    }

}
