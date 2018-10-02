package com.tm.perf.tool.api.response;

import java.util.Map;

import com.tm.perf.tool.api.common.BaseResponse;

public class UserResponse extends BaseResponse{
	Map<Integer,String> userdetailsMap;

	public Map<Integer, String> getUserdetailsMap() {
		return userdetailsMap;
	}

	public void setUserdetailsMap(Map<Integer, String> userdetailsMap) {
		this.userdetailsMap = userdetailsMap;
	}

	@Override
	public String toString() {
		return "UserResponse [userdetailsMap=" + userdetailsMap + "]";
	}
}
