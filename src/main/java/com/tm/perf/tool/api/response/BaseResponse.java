package com.tm.perf.tool.api.response;

import com.tm.perf.tool.constants.Constants.ErrorCodes;
import com.tm.perf.tool.constants.Constants.Status;

public class BaseResponse {
    
    private ErrorCodes errorMsg;
    private String errorCode;
    private Status status;
    
    public ErrorCodes getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(ErrorCodes errorMsg) {
        this.errorMsg = errorMsg;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
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
