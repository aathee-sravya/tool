package com.tm.perf.tool.api.response;

import org.springframework.http.HttpStatus;

public class ResponseBean<T> {
    HttpStatus httpStatus;
    String errorCode;
    String status;
    String errorMessage;
    T data;
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResponseBean [httpStatus=").append(httpStatus).append(", errorCode=").append(errorCode)
                .append(", status=").append(status).append(", errorMessage=").append(errorMessage).append(", data=")
                .append(data).append("]");
        return builder.toString();
    }
    
}
