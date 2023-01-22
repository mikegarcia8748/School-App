package com.mobilelearning.solutions.appcore.Address.model;

public class ProvinceInfo {

    private String sProvIDxx = "";
    private String sProvName = "";
    private String cRecdStat = "";
    private String dTimeStmp = "";

    public ProvinceInfo() {
    }

    public String getsProvIDxx() {
        return sProvIDxx;
    }

    public void setsProvIDxx(String sProvIDxx) {
        this.sProvIDxx = sProvIDxx;
    }

    public String getsProvName() {
        return sProvName;
    }

    public void setsProvName(String sProvName) {
        this.sProvName = sProvName;
    }

    public String getcRecdStat() {
        return cRecdStat;
    }

    public void setcRecdStat(String cRecdStat) {
        this.cRecdStat = cRecdStat;
    }

    public String getdTimeStmp() {
        return dTimeStmp;
    }

    public void setdTimeStmp(String dTimeStmp) {
        this.dTimeStmp = dTimeStmp;
    }
}
