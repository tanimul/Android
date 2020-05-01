package com.example.custom_navigation_drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        setTitle("Student activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
