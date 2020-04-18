package com.example.reminder;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;


import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Uri taskUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call();
    }

    private void call() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "hasan";
            String des = "dfafafeqfwvrg3qrgoqinlfmq3po";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel3 = new NotificationChannel(
                    "fuad",
                    "Channel 1",
                    importance
            );
            channel3.setDescription(des);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel3);

        }
    }

    public void OnClick(View v) {
        switch (v.getId()) {

            case R.id.b1:
                Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.YEAR,2020);
                calendar.set(Calendar.MONTH,3);
                calendar.set(Calendar.HOUR_OF_DAY,1);
                calendar.set(Calendar.MINUTE,33);
                calendar.set(Calendar.SECOND,0);
               Intent intent12 = new Intent(MainActivity.this, Alertreciver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent12, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(this, "alarm set", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
