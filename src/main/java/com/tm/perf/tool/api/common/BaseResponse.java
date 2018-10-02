package com.tm.perf.tool.api.common;

import com.tm.perf.tool.constants.Constants.ErrorCodes;
import com.tm.perf.tool.constants.Constants.Status;

public class BaseResponse {
    
    private String errorMsg;
    private ErrorCodes errorCode;
    private Status status;
    
    public BaseResponse(Status status) {
        super();
        this.status = status;
    }
    
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public ErrorCodes getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(ErrorCodes errorCode) {
        this.errorCode = errorCode;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseResponse [errorMsg=").append(errorMsg).append(", errorCode=").append(errorCode)
                .append(", status=").append(status).append("]");
        return builder.toString();
    }
    
}
