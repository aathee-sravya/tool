package com.tm.perf.tool.api.request;

public class LoginRequest {
    private String emailId;
    private String password;
    
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginUserRequest [emailId=").append(emailId).append(", password=").append(password).append("]");
        return builder.toString();
    }
    
}
