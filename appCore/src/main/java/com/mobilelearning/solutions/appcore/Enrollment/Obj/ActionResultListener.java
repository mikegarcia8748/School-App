package com.mobilelearning.solutions.appcore.Enrollment.Obj;

public interface ActionResultListener {
    void OnLoad();
    void OnSuccess(Object args);
    void OnFailed(String message);
}
