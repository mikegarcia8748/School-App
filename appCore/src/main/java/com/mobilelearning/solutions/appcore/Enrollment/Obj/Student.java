package com.mobilelearning.solutions.appcore.Enrollment.Obj;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.AggregateQuery;
import com.google.firebase.firestore.AggregateQuerySnapshot;
import com.google.firebase.firestore.AggregateSource;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mobilelearning.solutions.appcore.Address.model.BarangayInfo;
import com.mobilelearning.solutions.appcore.Address.model.ProvinceInfo;
import com.mobilelearning.solutions.appcore.Address.model.TownInfo;
import com.mobilelearning.solutions.appcore.Enrollment.Enroll;
import com.mobilelearning.solutions.appcore.Enrollment.model.StudentInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Student implements Enroll {
    private static final String TAG = Student.class.getSimpleName();

    private final Context mContext;

    private final FirebaseFirestore poSys;
    private String message;

    private int pnResult = 0;

    public Student(Context context) {
        this.mContext = context;
        poSys = FirebaseFirestore.getInstance();
    }

    @Override
    public List<BarangayInfo> GetBarangayList() {
        return null;
    }

    @Override
    public List<TownInfo> GetTownList() {
        return null;
    }

    @Override
    public List<ProvinceInfo> GetProvinceList() {
        return null;
    }

    @Override
    public String Save(Object obj) {
        try{
            StudentInfo loDetail = (StudentInfo) obj;

            if(!loDetail.isDataValid()){
                message = loDetail.getMessage();
                return null;
            }

            AggregateQuery loQuery = poSys.collection("Student_Info_Detail").count();
            loQuery.get(AggregateSource.SERVER).addOnCompleteListener(task -> {
                if(!task.isSuccessful()){
                   message = task.getException().getMessage();
                   pnResult = 2;
                } else {
                    AggregateQuerySnapshot loResult = task.getResult();
                    Log.d(TAG, "Student info count: " + loResult.getCount());
                    int lnRowCnt = (int) loResult.getCount();
                    String lsUnqID = CreateUniqueID(lnRowCnt);
                    loDetail.setsStudntID(lsUnqID);
                    poSys.collection("Student_Info_Detail").document(loDetail.getsStudntID()).set(loDetail)
                            .addOnSuccessListener(unused -> {
                                Log.d(TAG, "New student record has been saved! ");
                                pnResult = 1;
                            })
                            .addOnFailureListener(e -> {
                                Log.e(TAG, "Failed to save student record. Message: " + e.getMessage());
                                message = e.getMessage();
                                pnResult = 2;
                            });
                }
            });

            while (pnResult == 0){
                Log.d(TAG, "Waiting for result...");
            }

            if(pnResult > 1){
                return null;
            }

            return loDetail.getsStudntID();
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String CreateUniqueID(int rowCount){
        String lsUniqIDx = "";
        try{
            String lsBranchCd = "SCAPP";
            String lsCrrYear = new SimpleDateFormat("yy", Locale.getDefault()).format(new Date());
            StringBuilder loBuilder = new StringBuilder(lsBranchCd);
            loBuilder.append(lsCrrYear);

            int lnLocalID = rowCount + 1;
            String lsPadNumx = String.format("%05d", lnLocalID);
            loBuilder.append(lsPadNumx);
            lsUniqIDx = loBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        Log.d(TAG, lsUniqIDx);
        return lsUniqIDx;
    }
}
