package com.example.custom_nav_drawer_with_swipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    OnSwipeTouchListener onSwipeTouchListener;
    ImageView imageView, openmenu;
    TextView name, desc, fullname, fulldev;
    TextView explore, message, settings, signout;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    ConstraintLayout constraintLayout;
    Animation fromtop, frombottom, fromleft, fromright;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.profile_image);
        openmenu = findViewById(R.id.open_menu_pic);
        relativeLayout = findViewById(R.id.maincontent);
        linearLayout = findViewById(R.id.mainmenu);
        constraintLayout = findViewById(R.id.transparent_layer);

        name = findViewById(R.id.profile_name);


        explore = findViewById(R.id.explore);
        message = findViewById(R.id.message_id);
        settings = findViewById(R.id.settings);
        signout = findViewById(R.id.signout);

        fullname = findViewById(R.id.name_full_id);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(this, R.anim.fromright);

        openmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openmenufunc();


            }
        });


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        relativeLayout.setOnTouchListener(new OnSwipeTouchListener() {
            public boolean onSwipeTop() {

                return true;
            }

            public boolean onSwipeRight() {

                openmenufunc();
                return true;


            }

            public boolean onSwipeLeft() {

                return true;
            }

            public boolean onSwipeBottom() {

                return true;
            }
        });


        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                closemenu();

            }
        });


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linearLayout.setOnTouchListener(new OnSwipeTouchListener() {
            public boolean onSwipeTop() {

                return true;
            }

            public boolean onSwipeRight() {

                return true;


            }

            public boolean onSwipeLeft() {

                closemenu();
                return true;
            }

            public boolean onSwipeBottom() {

                return true;
            }
        });


    }

    private void closemenu() {
        relativeLayout.animate().translationX(-735);
        linearLayout.animate().translationX(-735);
        constraintLayout.animate().translationX(-695);
        constraintLayout.startAnimation(fromleft);
        relativeLayout.startAnimation(fromright);
        linearLayout.startAnimation(fromright);

        fullname.startAnimation(fromleft);
    }

    private void openmenufunc() {
        relativeLayout.animate().translationX(0);
        linearLayout.animate().translationX(0);
        constraintLayout.animate().translationX(-1095);
        constraintLayout.startAnimation(fromright);
        relativeLayout.startAnimation(fromleft);
        linearLayout.startAnimation(fromleft);

        explore.startAnimation(frombottom);
        message.startAnimation(frombottom);
        settings.startAnimation(frombottom);
        signout.startAnimation(frombottom);

        name.startAnimation(fromtop);
        imageView.startAnimation(fromtop);
    }

}
