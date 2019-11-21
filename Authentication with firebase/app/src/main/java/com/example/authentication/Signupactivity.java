package com.example.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Signupactivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signupmail,signuppass;
    private Button signupbutton;
    private TextView signuptext;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        this.setTitle("Sign up");
        mAuth = FirebaseAuth.getInstance();
        signupmail=findViewById(R.id.signupmail);
        signuppass=findViewById(R.id.signuppass);
        signupbutton=findViewById(R.id.signupbutton);
        signuptext=findViewById(R.id.signuptext);
        progressBar=findViewById(R.id.progressbarid);
        signupbutton.setOnClickListener(this);
        signuptext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signupbutton:
                userRegister();
                break;

            case R.id.signuptext:
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;


        }
    }

    private void userRegister() {
        String email=signupmail.getText().toString().trim();
        String password=signuppass.getText().toString().trim();
        //checking the validity of the email
        if(email.isEmpty())
        {
            signupmail.setError("Enter an email address");
            signupmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupmail.setError("Enter a valid email address");
            signupmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signuppass.setError("Enter a password");
            signuppass.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signuppass.setError("password must be 6 digit");
            signuppass.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if(task.isSuccessful()){
                    Toast.makeText(Signupactivity.this, "wow successfull", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent=new Intent(Signupactivity.this,NewActivity.class);
                    startActivity(intent);
                }
                else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(Signupactivity.this, "User is already Registered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Signupactivity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
