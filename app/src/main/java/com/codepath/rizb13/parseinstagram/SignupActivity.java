package com.codepath.rizb13.parseinstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";

    public EditText etSignupUser;
    public EditText etSignupPassword;
    public Button btnSignupUser;
    public Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etSignupUser = findViewById(R.id.etSignupUser);
        etSignupPassword = findViewById(R.id.etSignupPassword);
        btnSignupUser = findViewById(R.id.btnSignupUser);
        btnHome = findViewById(R.id.btnHome);

        btnSignupUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etSignupUser.getText().toString().isEmpty() &&
                        !etSignupPassword.getText().toString().isEmpty()){

                    ParseUser user = new ParseUser();
                    user.setUsername(etSignupUser.getText().toString());
                    user.setPassword(etSignupPassword.getText().toString());

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                                Toast.makeText(getApplicationContext(), "Signup Successful", Toast.LENGTH_LONG).show();
                                goMainActivity();
                            }else{
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginActivity();
            }
        });
    }

    private void goMainActivity() {
        Log.d(TAG, "Navigating to Main Activity");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goLoginActivity() {
        Log.d(TAG, "Navigating to Login Activity");
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}