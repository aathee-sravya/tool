package com.tm.perf.tool.api.common;

import com.tm.perf.tool.common.Constants.ErrorCodes;
import com.tm.perf.tool.common.Constants.HTTPResponse;

public class BaseResponse {
    
    private String errorMsg;
    private ErrorCodes errorCode;
    private HTTPResponse status;
    
    public BaseResponse(HTTPResponse status) {
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
    public HTTPResponse getStatus() {
        return status;
    }
    public void setStatus(HTTPResponse status) {
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
