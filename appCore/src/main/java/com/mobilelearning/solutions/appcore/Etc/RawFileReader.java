package com.mobilelearning.solutions.appcore.Etc;

import android.content.Context;

import java.io.InputStream;

public class RawFileReader {

    public static String ReadTextFile(Context context, int txtID) throws Exception{
        InputStream is = context.getResources().openRawResource(txtID);
        byte[] buffer = new byte[is.available()];
        while (is.read(buffer) != -1);
        String jsontext = new String(buffer);
        return jsontext;
    }
}
