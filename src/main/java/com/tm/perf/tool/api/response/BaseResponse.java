package com.tm.perf.tool.api.response;

import org.springframework.http.HttpStatus;

import com.tm.perf.tool.common.Constants.HTTPResponse;

public class BaseResponse {
	
	private HTTPResponse status;
	
	private HttpStatus errorCode;
	
	private String errorDesciption;

	public HTTPResponse getStatus() {
		return status;
	}

	public void setStatus(HTTPResponse status) {
		this.status = status;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesciption() {
		return errorDesciption;
	}

	public void setErrorDesciption(String errorDesciption) {
		this.errorDesciption = errorDesciption;
	}

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + ", errorCode=" + errorCode + ", errorDesciption=" + errorDesciption
				+ "]";
	}
}
