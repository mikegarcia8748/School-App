package com.mobilelearning.solutions.appcore.Address.model;

public class TownProvince {
    private final String sTownIDxx;
    private final String sTownName;
    private final String sProvName;

    public TownProvince(String sTownIDxx, String sTownName, String sProvName) {
        this.sTownIDxx = sTownIDxx;
        this.sTownName = sTownName;
        this.sProvName = sProvName;
    }

    public String getsTownIDxx() {
        return sTownIDxx;
    }

    public String getsTownName() {
        return sTownName;
    }

    public String getsProvName() {
        return sProvName;
    }
}
