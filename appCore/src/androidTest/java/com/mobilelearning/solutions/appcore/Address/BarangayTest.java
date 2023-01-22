package com.mobilelearning.solutions.appcore.Address;


import android.app.Application;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;

import com.google.firebase.FirebaseApp;
import com.mobilelearning.solutions.appcore.Address.Obj.Barangay;
import com.mobilelearning.solutions.appcore.Address.model.BarangayInfo;
import com.mobilelearning.solutions.appcore.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class BarangayTest {
    private static final String TAG = BarangayTest.class.getSimpleName();

    private Application instance;
    private Barangay poSys;

    @Before
    public void setUp() throws Exception {
        instance = ApplicationProvider.getApplicationContext();
        FirebaseApp.initializeApp(instance);
        poSys = new Barangay(instance);
    }

    @After
    public void tearDown() throws Exception {
        Log.d(TAG, "Test ended");
    }

    @Test
    public void test01SaveRecords() throws Exception{

    }

    private String ReadTextFile(int txtID) throws Exception{
        InputStream is = instance.getResources().openRawResource(txtID);
        byte[] buffer = new byte[is.available()];
        while (is.read(buffer) != -1);
        String jsontext = new String(buffer);
        return jsontext;
    }
}
