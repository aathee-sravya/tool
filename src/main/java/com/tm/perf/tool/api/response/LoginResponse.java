package com.tm.perf.tool.api.response;

import com.tm.perf.tool.api.common.BaseResponse;
import com.tm.perf.tool.common.Constants.HTTPResponse;

public class LoginResponse extends BaseResponse{

    public LoginResponse(HTTPResponse status) {
        super(status);
        // TODO Auto-generated constructor stub
    }
    
    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginResponse [uniqueId=").append(uniqueId).append("]");
        return builder.toString();
    }

}
