package com.example.google_maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DetailsInformationlocation extends AppCompatActivity {
    private Button b1;
    private TextView t1, t2, t3, t4, t5;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_informationlocation);
        b1 = findViewById(R.id.button1);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(DetailsInformationlocation.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(DetailsInformationlocation.this, "working", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(DetailsInformationlocation.this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                    return;
                }
                getlocation();

            }
        });
    }

    private void getlocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {

                    try {
                        Geocoder geocoder = new Geocoder(DetailsInformationlocation.this, Locale.getDefault());
                        List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        t1.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Latitude : </b><br></font>"
                                        + addressList.get(0).getLatitude()
                        ));
                        t2.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Longitude : </b><br></font>"
                                        + addressList.get(0).getLongitude()
                        ));
                        t3.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Country name : </b><br></font>"
                                        + addressList.get(0).getCountryName()
                        ));
                        t4.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Locality : </b><br></font>"
                                        + addressList.get(0).getLocality()
                        ));
                        t5.setText(Html.fromHtml(
                                "<font color='#6200EE'><b>Address : </b><br></font>"
                                        + addressList.get(0).getAddressLine(0)
                        ));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
