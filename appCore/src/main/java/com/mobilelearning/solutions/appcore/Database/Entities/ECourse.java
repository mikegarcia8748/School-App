package com.mobilelearning.solutions.appcore.Database.Entities;

public class ECourse {
    private String sCourseID = "";
    private String sCourseCD = "";
    private String sDescript = "";
    private Double nUnitsReq = 0.0;
    private String dModified = "";
    private String dTimeStmp = "";

    public ECourse() {
    }

    public String getsCourseID() {
        return sCourseID;
    }

    public void setsCourseID(String sCourseID) {
        this.sCourseID = sCourseID;
    }

    public String getsCourseCD() {
        return sCourseCD;
    }

    public void setsCourseCD(String sCourseCD) {
        this.sCourseCD = sCourseCD;
    }

    public String getsDescript() {
        return sDescript;
    }

    public void setsDescript(String sDescript) {
        this.sDescript = sDescript;
    }

    public Double getnUnitsReq() {
        return nUnitsReq;
    }

    public void setnUnitsReq(Double nUnitsReq) {
        this.nUnitsReq = nUnitsReq;
    }

    public String getdModified() {
        return dModified;
    }

    public void setdModified(String dModified) {
        this.dModified = dModified;
    }

    public String getdTimeStmp() {
        return dTimeStmp;
    }

    public void setdTimeStmp(String dTimeStmp) {
        this.dTimeStmp = dTimeStmp;
    }
}
