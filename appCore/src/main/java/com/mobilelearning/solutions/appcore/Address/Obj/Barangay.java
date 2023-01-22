package com.mobilelearning.solutions.appcore.Address.Obj;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mobilelearning.solutions.appcore.Address.model.BarangayInfo;

import java.util.List;

public class Barangay {
    private static final String TAG = Barangay.class.getSimpleName();

    private final FirebaseFirestore poSys;
    private String message;

    public Barangay(Context context) {
        FirebaseApp.initializeApp(context);
        poSys = FirebaseFirestore.getInstance();
    }

    public boolean Insert(Object obj) {
        try{
            List<BarangayInfo> loBrgy = (List<BarangayInfo>) obj;

            for(int x = 5999; x < loBrgy.size(); x++){
                BarangayInfo objBrgy = loBrgy.get(x);

                int finalX = x;
                poSys.collection("Barangay").document(objBrgy.getsBrgyIDxx()).set(objBrgy)
                        .addOnSuccessListener(unused -> {
                            Log.d(TAG, "New barangay record has been saved! " + finalX);
                        })
                        .addOnFailureListener(e -> {
                            Log.e(TAG, "Failed to save barangay record. Message: " + e.getMessage() + " " + finalX);
                        });
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
