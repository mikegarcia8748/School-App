package com.mobilelearning.solutions.enrollment.Activities;

import static com.mobilelearning.solutions.appcore.Etc.RawFileReader.ReadTextFile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.mobilelearning.solutions.appcore.Address.Obj.Barangay;
import com.mobilelearning.solutions.appcore.Address.model.BarangayInfo;
import com.mobilelearning.solutions.enrollment.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activity_StudentInfo extends AppCompatActivity {
    private static final String TAG = Activity_StudentInfo.class.getSimpleName();

    private Toolbar toolbar;
    private TextInputEditText txtLastName,
            txtFrstName,
            txtMiddName,
            txtSuffixNm,
            txtBrthDate,
            txtEmailxxx,
            txtMobileNo;
    private AutoCompleteTextView txtBirthPlc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        initWidgets();
        try {
            Barangay loSys = new Barangay(Activity_StudentInfo.this);
            String lsJson = ReadTextFile(Activity_StudentInfo.this, com.mobilelearning.solutions.appcore.R.raw.barangay_json);
            JSONObject loJson = new JSONObject(lsJson);
            JSONArray laJson = loJson.getJSONArray("detail");

            List<BarangayInfo> loBrgy = new ArrayList<>();
            for (int x = 0; x < laJson.length(); x++) {
                JSONObject joBrgy = laJson.getJSONObject(x);
                BarangayInfo objBrgy = new BarangayInfo();
                objBrgy.setsBrgyIDxx(joBrgy.getString("sBrgyIDxx"));
                objBrgy.setsBrgyName(joBrgy.getString("sBrgyName"));
                objBrgy.setsTownIDxx(joBrgy.getString("sTownIDxx"));
                objBrgy.setcRecdStat(joBrgy.getString("cRecdStat"));
                objBrgy.setdTimeStmp(joBrgy.getString("dTimeStmp"));
                loBrgy.add(objBrgy);
            }

            if(!loSys.Insert(loBrgy)){
                Log.e(TAG, loSys.getMessage());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private void initWidgets(){
        toolbar = findViewById(R.id.toolbar);
        txtLastName = findViewById(R.id.txtLastName);
        txtFrstName = findViewById(R.id.txtFirstName);
        txtMiddName = findViewById(R.id.txtMiddName);
        txtSuffixNm = findViewById(R.id.txtSuffix);
        txtBrthDate = findViewById(R.id.txtBirthDate);
        txtEmailxxx = findViewById(R.id.txtEmail);
        txtMobileNo = findViewById(R.id.txtMobileNo);
        txtBirthPlc = findViewById(R.id.txtBirthPlce);
    }
}