package com.example.custom_navigation_drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sNavigationDrawer = findViewById(R.id.navigationDrawer);

        List<com.shrikanthravi.customnavigationdrawer2.data.MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Test ", R.drawable.news_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Student", R.drawable.feed_bg));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Teacher", R.drawable.message_bg));
        sNavigationDrawer.setMenuItemList(menuItems);

        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Test.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Student.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Teacher.class));
                        break;


                }
            }
        });
    }
}
