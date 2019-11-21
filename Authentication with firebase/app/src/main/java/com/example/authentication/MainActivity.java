package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signinmail, signinpass;
    private TextView signintext;
    private Button signinbutton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");
        mAuth = FirebaseAuth.getInstance();
        signinmail = findViewById(R.id.signinemail);
        signinpass = findViewById(R.id.signinpass);
        signinbutton = findViewById(R.id.signinbutton);
        signintext = findViewById(R.id.signintext);
        progressBar = findViewById(R.id.progressbarid);
        signinbutton.setOnClickListener(this);
        signintext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signinbutton:
                userlogin();
                break;

            case R.id.signintext:
                Intent intent = new Intent(getApplicationContext(), Signupactivity.class);
                startActivity(intent);
                break;


        }

    }

    private void userlogin() {
        String email = signinmail.getText().toString().trim();
        String password = signinpass.getText().toString().trim();
        //checking the validity of the email
        if (email.isEmpty()) {
            signinmail.setError("Enter an email address");
            signinmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signinmail.setError("Enter a valid email address");
            signinmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            signinpass.setError("Enter a password");
            signinpass.requestFocus();
            return;
        }
        if (password.length() < 6) {
            signinpass.setError("password must be 6 digit");
            signinpass.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "wow successfull", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent=new Intent(MainActivity.this,NewActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Unsucess", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
