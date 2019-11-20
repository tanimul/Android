package com.example.fragmenthw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b10=findViewById(R.id.b10);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;
        Bundle bundle=new Bundle();
        bundle.putString("data","Nice Color");

        switch (view.getId()){
            case R.id.b1:
                fragment=new b1();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
                case R.id.b2:
                    fragment=new b2();
                    fragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b3:
                fragment=new b3();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b4:
                fragment=new b4();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b5:
                fragment=new b5();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b6:
                fragment=new b6();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b7:
                fragment=new b7();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b8:
                fragment=new b8();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b9:
                fragment=new b9();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
            case R.id.b10:
                fragment=new b10();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
                break;
        }

    }
}
