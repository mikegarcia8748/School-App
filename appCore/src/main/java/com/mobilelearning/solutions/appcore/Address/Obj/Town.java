package com.mobilelearning.solutions.appcore.Address.Obj;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mobilelearning.solutions.appcore.Address.model.TownInfo;

import java.util.List;

public class Town {
    private static final String TAG = Town.class.getSimpleName();

    private final FirebaseFirestore poSys;

    private String message;

    public Town(Context context) {
        FirebaseApp.initializeApp(context);
        poSys = FirebaseFirestore.getInstance();
    }

    public boolean Insert(Object obj) {
        try {
            List<TownInfo> loList = (List<TownInfo>) obj;
            for (int x = 0; x < loList.size(); x++) {
                TownInfo loDetail = loList.get(x);

                int finalX = x;
                DocumentReference key = poSys.collection("TownInfo").document();
                poSys.collection("TownInfo").document(loDetail.getsTownIDxx()).set(loDetail)
                        .addOnSuccessListener(unused -> Log.d(TAG, "New barangay record has been saved! " + finalX))
                        .addOnFailureListener(e -> Log.e(TAG, "Failed to save barangay record. Message: " + e.getMessage() + " " + finalX));
            }

            return true;
        } catch (Exception e){
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
