package com.tm.perf.tool.api.response;

import com.tm.perf.tool.api.common.BaseResponse;
import com.tm.perf.tool.constants.Constants.Status;

public class CreateUserResponse extends BaseResponse{
    
    public CreateUserResponse(Status status) {
        super(status);
        // TODO Auto-generated constructor stub
    }

    private String userUniqId;
    private String signUpdate;
    
    public String getUserUniqId() {
        return userUniqId;
    }
    public void setUserUniqId(String userUniqId) {
        this.userUniqId = userUniqId;
    }
    public String getSignUpdate() {
        return signUpdate;
    }
    public void setSignUpdate(String signUpdate) {
        this.signUpdate = signUpdate;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CreateUserResponse [userUniqId=").append(userUniqId).append(", signUpdate=").append(signUpdate)
                .append("]");
        return builder.toString();
    }
   
}
