package com.mobilelearning.solutions.appcore.Authentication;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mobilelearning.solutions.appcore.R;

public class UserAuthentication {
    private static final String TAG = UserAuthentication.class.getSimpleName();

    private final Context mContext;
    private String message;

    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;

    public interface OnSignInGoogleAccountListener{
        void InitializeAccount(BeginSignInResult result);
        void OnFailed(String message);
    }

    public UserAuthentication(Context context) {
        this.mContext = context;
    }

    public void InitializeAccount(Activity activity, OnSignInGoogleAccountListener listener){
        try{
            oneTapClient = Identity.getSignInClient(activity);
            signInRequest = BeginSignInRequest.builder()
                    .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
                            .setSupported(true)
                            .build())
                    .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                            .setSupported(true)
                            .setServerClientId(mContext.getString(R.string.default_app_client_id))
                            .setFilterByAuthorizedAccounts(false)
                            .build())
                    .build();

            oneTapClient.beginSignIn(signInRequest)
                    .addOnSuccessListener(activity, new OnSuccessListener<BeginSignInResult>() {
                        @Override
                        public void onSuccess(BeginSignInResult beginSignInResult) {
                            listener.InitializeAccount(beginSignInResult);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "Sign up failed. " + e.getMessage());
                            listener.OnFailed(e.getMessage());
                        }
                    });
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            listener.OnFailed(message);
        }
    }

    public void SignIn(ActivityResult result){

    }
}
