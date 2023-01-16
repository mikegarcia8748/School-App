package com.mobilelearning.solutions.school_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobilelearning.solutions.appcore.Database.Entities.ECourse;
import com.mobilelearning.solutions.school_app.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ECourse loCourse = new ECourse();
        loCourse.setsCourseID("SCX121021589");
        loCourse.setsCourseCD("BSIT");
        loCourse.setsDescript("Bachelor of Science in Information Technoloy");
        loCourse.setnUnitsReq(48.0);
        loCourse.setdModified(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        loCourse.setdTimeStmp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        FirebaseDatabase loDB = FirebaseDatabase.getInstance();
        DatabaseReference loRef = loDB.getReference("CourseMaster");
        String lsUnqIDxx = loRef.push().getKey();
        loRef.child(lsUnqIDxx).setValue(loCourse).addOnCompleteListener(task -> Log.d(TAG, "A new course record has been save successfully"));
    }
}