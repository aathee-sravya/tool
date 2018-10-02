package com.tm.perf.tool.service;

import com.tm.perf.tool.api.response.config.UserInfoResponse;


public interface AdminConfigurationService {
	
	public UserInfoResponse userInfo(String companyId);
	
}
