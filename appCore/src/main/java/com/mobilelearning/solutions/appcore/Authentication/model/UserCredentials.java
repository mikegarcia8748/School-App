package com.mobilelearning.solutions.appcore.Authentication.model;

public class UserCredentials {
    private String sEmailAdd = "";
    private String sPassword = "";
    private String sUserName = "";
    private String sMobileNo = "";
    private String cAcctType = "";
    private String dCreatedx = "";

    public UserCredentials() {
    }

    public String getsEmailAdd() {
        return sEmailAdd;
    }

    public void setsEmailAdd(String sEmailAdd) {
        this.sEmailAdd = sEmailAdd;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsUserName() {
        return sUserName;
    }

    public void setsUserName(String sUserName) {
        this.sUserName = sUserName;
    }

    public String getsMobileNo() {
        return sMobileNo;
    }

    public void setsMobileNo(String sMobileNo) {
        this.sMobileNo = sMobileNo;
    }

    public String getcAcctType() {
        return cAcctType;
    }

    public void setcAcctType(String cAcctType) {
        this.cAcctType = cAcctType;
    }

    public String getdCreatedx() {
        return dCreatedx;
    }

    public void setdCreatedx(String dCreatedx) {
        this.dCreatedx = dCreatedx;
    }
}
