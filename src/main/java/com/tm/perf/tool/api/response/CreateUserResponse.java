package com.tm.perf.tool.api.response;

public class CreateUserResponse {
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
