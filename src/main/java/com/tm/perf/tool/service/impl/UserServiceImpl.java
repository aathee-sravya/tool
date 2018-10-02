package com.tm.perf.tool.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.response.CreateUserResponse;
import com.tm.perf.tool.dao.UserDao;
import com.tm.perf.tool.dao.impl.UserDaoImpl;
import com.tm.perf.tool.request.ReviewReport;
import com.tm.perf.tool.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public ReviewReport getReviewReport() {
		return userdao.getReviewReport();
	}

    @Override
    public CreateUserResponse loginUser(LoginRequest loginRequest) {
        return userdao.loginUser(loginRequest);
    }

}
