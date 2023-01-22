package com.mobilelearning.solutions.enrollment.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.mobilelearning.solutions.appcore.Address.model.TownProvince;

import java.util.List;

public class VMStudentInfo extends AndroidViewModel {
    private static final String TAG = VMStudentInfo.class.getSimpleName();

    private String message;

    public VMStudentInfo(@NonNull Application application) {
        super(application);
    }
}
