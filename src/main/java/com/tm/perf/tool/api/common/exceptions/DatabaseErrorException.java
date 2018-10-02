package com.tm.perf.tool.api.common.exceptions;

import com.tm.perf.tool.common.Constants.ErrorCodes;

public class DatabaseErrorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorCodes errorCodes = ErrorCodes.technical_error;
	
	private String message;
	
	public DatabaseErrorException(String message){
		this.message=message;
	}

	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(ErrorCodes errorCodes) {
		this.errorCodes = errorCodes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
