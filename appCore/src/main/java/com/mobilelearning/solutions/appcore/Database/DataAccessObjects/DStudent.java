package com.mobilelearning.solutions.appcore.Database.DataAccessObjects;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilelearning.solutions.appcore.Database.Entities.EStudent;

public class DStudent {
    private static final String TAG = DStudent.class.getSimpleName();

    private final Context mContext;
    private final FirebaseDatabase poDB;

    private String message;

    public DStudent(Context context) {
        this.mContext = context;
        poDB = FirebaseDatabase.getInstance();
    }

    public boolean Save(EStudent args){
        try{
            DatabaseReference loRef = poDB.getReference("Student_Master");

            loRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String lsValue = snapshot.getValue(String.class);
                    Log.d(TAG, "Value is: " + lsValue);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean Update(EStudent args){
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public EStudent GetStudent(){
        try{
            EStudent loDetail = new EStudent();
            return loDetail;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }
}
