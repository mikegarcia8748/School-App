package com.mobilelearning.solutions.appcore.Enrollment.model;

public class StudentInfo {
    private String sStudntID = "";
    private String sLastName = "";
    private String sFrstName = "";
    private String sMiddName = "";
    private String sSuffixNm = "";
    private String sBrthDate = "";
    private String sBrthPlce = "";
    private String sEmailxxx = "";
    private String sMobileNo = "";

    private String message;

    public StudentInfo() {
    }

    public String getMessage() {
        return message;
    }

    public String getsStudntID() {
        return sStudntID;
    }

    public void setsStudntID(String sStudntID) {
        this.sStudntID = sStudntID;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getsFrstName() {
        return sFrstName;
    }

    public void setsFrstName(String sFrstName) {
        this.sFrstName = sFrstName;
    }

    public String getsMiddName() {
        return sMiddName;
    }

    public void setsMiddName(String sMiddName) {
        this.sMiddName = sMiddName;
    }

    public String getsSuffixNm() {
        return sSuffixNm;
    }

    public void setsSuffixNm(String sSuffixNm) {
        this.sSuffixNm = sSuffixNm;
    }

    public String getsBrthDate() {
        return sBrthDate;
    }

    public void setsBrthDate(String sBrthDate) {
        this.sBrthDate = sBrthDate;
    }

    public String getsBrthPlce() {
        return sBrthPlce;
    }

    public void setsBrthPlce(String sBrthPlce) {
        this.sBrthPlce = sBrthPlce;
    }

    public String getsEmailxxx() {
        return sEmailxxx;
    }

    public void setsEmailxxx(String sEmailxxx) {
        this.sEmailxxx = sEmailxxx;
    }

    public String getsMobileNo() {
        return sMobileNo;
    }

    public void setsMobileNo(String sMobileNo) {
        this.sMobileNo = sMobileNo;
    }

    public boolean isDataValid(){
        if(sLastName.trim().isEmpty()){
            message = "Please enter last name.";
            return false;
        }
        if(sFrstName.trim().isEmpty()){
            message = "Please enter first name.";
            return false;
        }
        if(sBrthDate.trim().isEmpty()){
            message = "Please enter birth date.";
            return false;
        }
        if(sBrthPlce.trim().isEmpty()){
            message = "Please enter birth place.";
            return false;
        }
        if(sMobileNo.trim().isEmpty()){
            message = "Please enter mobile no.";
            return false;
        }
        return true;
    }
}
