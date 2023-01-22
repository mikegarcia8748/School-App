package com.mobilelearning.solutions.appcore.Address.Obj;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mobilelearning.solutions.appcore.Address.model.ProvinceInfo;

import java.util.List;

public class Province {
    private static final String TAG = Province.class.getSimpleName();

    private final FirebaseFirestore poSys;

    private String message;

    public Province(Context context) {
        FirebaseApp.initializeApp(context);
        poSys = FirebaseFirestore.getInstance();
    }

    public boolean Insert(Object obj) {
        try {
            List<ProvinceInfo> loList = (List<ProvinceInfo>) obj;
            for (int x = 0; x < loList.size(); x++) {
                ProvinceInfo loDetail = loList.get(x);

                int finalX = x;
                DocumentReference key = poSys.collection("ProvinceInfo").document();
                poSys.collection("ProvinceInfo").document(loDetail.getsProvIDxx()).set(loDetail)
                        .addOnSuccessListener(unused -> Log.d(TAG, "New province record has been saved! " + finalX))
                        .addOnFailureListener(e -> Log.e(TAG, "Failed to save province record. Message: " + e.getMessage() + " " + finalX));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean Update(Object obj) {
        return false;
    }

    public Object GetList() {
        return null;
    }

    public Object GetInfo(String args) {
        return null;
    }

    public String getMessage() {
        return message;
    }
}
