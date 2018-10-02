package com.tm.perf.tool.dao;

import java.util.List;

import com.tm.perf.tool.api.common.exceptions.DatabaseErrorException;
import com.tm.perf.tool.api.request.config.UserInfo;

public interface AdminConfigurationDAO {
	
	public List<UserInfo> getUserInfo(String companyId) throws DatabaseErrorException;
}
