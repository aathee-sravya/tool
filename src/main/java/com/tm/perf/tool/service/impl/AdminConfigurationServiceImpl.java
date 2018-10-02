package com.tm.perf.tool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.perf.tool.api.common.exceptions.DatabaseErrorException;
import com.tm.perf.tool.api.request.config.UserInfo;
import com.tm.perf.tool.api.response.config.UserInfoResponse;
import com.tm.perf.tool.common.Constants.ErrorCodes;
import com.tm.perf.tool.common.Constants.HTTPResponse;
import com.tm.perf.tool.dao.AdminConfigurationDAO;
import com.tm.perf.tool.service.AdminConfigurationService;

@Service
public class AdminConfigurationServiceImpl implements AdminConfigurationService{
	
	@Autowired
	private AdminConfigurationDAO AdminConfigurationDAO;

	@Override
	public UserInfoResponse userInfo(String companyId) {
		UserInfoResponse userInfoResponse = new UserInfoResponse(HTTPResponse.SUCCESS);
		try {
		List<UserInfo> userInfoList = AdminConfigurationDAO.getUserInfo(companyId);
		userInfoResponse.setUserInfoList(userInfoList);
		}catch (DatabaseErrorException e) {
			userInfoResponse.setStatus(HTTPResponse.FAILED);
			userInfoResponse.setErrorCode(e.getErrorCodes());
			userInfoResponse.setErrorMsg(e.getMessage());
			return userInfoResponse;
		}
		catch (Exception e) {
			userInfoResponse.setStatus(HTTPResponse.FAILED);
			userInfoResponse.setErrorCode(ErrorCodes.technical_error);
			userInfoResponse.setErrorMsg(e.getLocalizedMessage());
			return userInfoResponse;
		}
		return userInfoResponse;
	}
	
}
