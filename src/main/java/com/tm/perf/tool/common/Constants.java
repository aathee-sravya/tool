package com.tm.perf.tool.common;

public class Constants {
	
	
	public static final Integer DB_SUCCESS = 1;

	public static enum HTTPResponse {
		SUCCESS,FAILED;
	}
	
	public enum ErrorCodes {
        user_already_exists,
        invalid_mobile,
        invalid_email,
        invalid_password,
        technical_error
        
    }
}
