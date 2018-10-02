package com.tm.perf.tool.api.request;

public class UserInfoRequest {
    
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
        builder.append("UserInfoRequest [uniqueId=").append(uniqueId).append("]");
        return builder.toString();
    }
}
