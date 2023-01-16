package com.mobilelearning.solutions.appcore.Authentication.model;

public class LoginCredentials {
    private String sEmailAdd = "";
    private String sPassword = "";

    public LoginCredentials() {
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
}
