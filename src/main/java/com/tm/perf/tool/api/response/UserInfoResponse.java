package com.tm.perf.tool.api.response;

public class UserInfoResponse {
    
    private String uniqUserId;
    private String userName;
    private String fName;
    private String lName;
    private String primaryEmail;
    private String officeEmail;
    private String mobileNum;
    private String officeNum;
    private String emergencyContact;
    private String dob;
    private String primaryAddress;
    private String permanentAddress;
    public String getUniqUserId() {
        return uniqUserId;
    }
    public void setUniqUserId(String uniqUserId) {
        this.uniqUserId = uniqUserId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getPrimaryEmail() {
        return primaryEmail;
    }
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }
    public String getOfficeEmail() {
        return officeEmail;
    }
    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }
    public String getMobileNum() {
        return mobileNum;
    }
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    public String getOfficeNum() {
        return officeNum;
    }
    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getPrimaryAddress() {
        return primaryAddress;
    }
    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
    public String getPermanentAddress() {
        return permanentAddress;
    }
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserInfoResponse [uniqUserId=").append(uniqUserId).append(", userName=").append(userName)
                .append(", fName=").append(fName).append(", lName=").append(lName).append(", primaryEmail=")
                .append(primaryEmail).append(", officeEmail=").append(officeEmail).append(", mobileNum=")
                .append(mobileNum).append(", officeNum=").append(officeNum).append(", emergencyContact=")
                .append(emergencyContact).append(", dob=").append(dob).append(", primaryAddress=")
                .append(primaryAddress).append(", permanentAddress=").append(permanentAddress).append("]");
        return builder.toString();
    }
    
}
