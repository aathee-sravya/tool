package com.tm.perf.tool.api.response.config;

import java.util.List;

import com.tm.perf.tool.api.common.BaseResponse;
import com.tm.perf.tool.api.request.config.UserInfo;
import com.tm.perf.tool.common.Constants.HTTPResponse;

public class UserInfoResponse extends BaseResponse{
	
	private List<UserInfo> userInfoList; 
	
	public UserInfoResponse(HTTPResponse htttpResponse) {
		super(htttpResponse);
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	@Override
	public String toString() {
		return "UserInfoResponse [userInfoList=" + userInfoList + ", getErrorMsg()=" + getErrorMsg()
				+ ", getErrorCode()=" + getErrorCode() + ", getStatus()=" + getStatus() + "]";
	}
}
