package com.mobilelearning.solutions.auth.Activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.mobilelearning.solutions.auth.R;

public class Activity_SignIn extends AppCompatActivity {
    private static final String TAG = Activity_SignIn.class.getSimpleName();
    private static final int REQ_ONE_TAP = 1;

    private FirebaseAuth mAuth;

    private TextInputEditText txtEmail,
                              txtPswrd;

    private MaterialButton btnSignUp;
    private SignInButton signInButton;

    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;

    private ActivityResultLauncher<Intent> poSignIn = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
//            handleSignInResult(task);
            try {
                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(result.getData());
                String idToken = credential.getGoogleIdToken();
                String username = credential.getId();
                String password = credential.getPassword();
                if (idToken != null) {
                    // Got an ID token from Google. Use it to authenticate
                    // with your backend.
                    Log.d(TAG, "Got ID token.");
                } else if (password != null) {
                    // Got a saved username and password. Use them to authenticate
                    // with your backend.
                    Log.d(TAG, "Got password.");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(Activity_SignIn.this, gso);

        oneTapClient = Identity.getSignInClient(Activity_SignIn.this);
        signInRequest = BeginSignInRequest.builder()
                .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
                        .setSupported(true)
                        .build())
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId(getString(com.mobilelearning.solutions.appcore.R.string.default_app_client_id))
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .build();

        txtEmail = findViewById(R.id.tieEmail);
        txtPswrd = findViewById(R.id.tiePassword);
        btnSignUp = findViewById(R.id.btnSignup);
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//                poSignIn.launch(signInIntent);
//                startActivityForResult(signInIntent, RC_SIGN_IN);

                oneTapClient.beginSignIn(signInRequest)
                        .addOnSuccessListener(Activity_SignIn.this, new OnSuccessListener<BeginSignInResult>() {
                            @Override
                            public void onSuccess(BeginSignInResult beginSignInResult) {
//                        Log.d(TAG, "Account save successfully");
//                        Toast.makeText(Activity_SignIn.this, "Account save successfully", Toast.LENGTH_SHORT).show();
                                try {
//                            poSignIn.launch(beginSignInResult.getPendingIntent().getIntentSender());
                                    startIntentSenderForResult(
                                            beginSignInResult.getPendingIntent().getIntentSender(), REQ_ONE_TAP,
                                            null, 0, 0, 0);
                                } catch (IntentSender.SendIntentException e) {
                                    Log.e(TAG, "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG, "Sign up failed. " + e.getMessage());
                                Toast.makeText(Activity_SignIn.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });


    }

    private void signUp(){
        try{
            String lsEmail = txtEmail.getText().toString();
            String lsPswrd = txtPswrd.getText().toString();
            if(lsEmail.isEmpty()){
                return;
            }

            if(lsPswrd.isEmpty()){
                return;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        FirebaseAuth.getInstance().signOut();
        super.onDestroy();
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//
//            Toast.makeText(Activity_SignIn.this, "Login success!", Toast.LENGTH_SHORT).show();
//            Log.d(TAG, "Login success!");
//            // Signed in successfully, show authenticated UI.
////            updateUI(account);
//        } catch (ApiException e) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//
//            Toast.makeText(Activity_SignIn.this, "Login failed!", Toast.LENGTH_SHORT).show();
//            Log.e(TAG, "signInResult:failed code=" + e.getStatusCode());
////            updateUI(null);
//        }
    }
}