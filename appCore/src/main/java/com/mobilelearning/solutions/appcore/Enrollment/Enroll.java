package com.mobilelearning.solutions.appcore.Enrollment;

import com.mobilelearning.solutions.appcore.Address.model.BarangayInfo;
import com.mobilelearning.solutions.appcore.Address.model.ProvinceInfo;
import com.mobilelearning.solutions.appcore.Address.model.TownInfo;

import java.util.List;

public interface Enroll {
    List<BarangayInfo> GetBarangayList();
    List<TownInfo> GetTownList();
    List<ProvinceInfo> GetProvinceList();
    String Save(Object obj);

    String getMessage();
}
