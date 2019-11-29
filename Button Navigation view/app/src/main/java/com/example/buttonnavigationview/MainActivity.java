package com.example.buttonnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.butttomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new first()).commit();
    }

    //    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        Fragment fragment;
//
//        @Override
//
//
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            switch (menuItem.getItemId()) {
//                case R.id.first:
//                    fragment = new first();
//                    break;
//                case R.id.second:
//                    fragment = new second();
//                    break;
//                case R.id.third:
//                    fragment = new third();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
//            return true;
//        }
//    };
//}
// Okay ??
    //yes.thank u vaiya
    //allah hafez

 @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
     Toast.makeText(this, "hai allah", Toast.LENGTH_SHORT).show();
        switch (menuItem.getItemId()) {
            case R.id.firstbuttom:
                fragment = new first();
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break;
            case R.id.secbuttom:
                fragment = new second();
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break;
            case R.id.thirdbuttom:
                fragment = new third();
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break;
        }
//        if (menuItem.getItemId() == R.id.first) {
//            fragment = new first();
//            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
//
//        }

        return true;
    }
}

