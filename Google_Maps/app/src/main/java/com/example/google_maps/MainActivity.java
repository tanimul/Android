package com.example.google_maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CHECK_SETTINGS = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.location_enable:
                displayLocationSettingsRequest(MainActivity.this);
                break;


            case R.id.enableornot:
                checkSetting(MainActivity.this);
                break;


            case R.id.simple_mapinit:
                startActivity(new Intent(MainActivity.this, SimpleMapActivity.class));
                break;

            case R.id.cur_location:
                startActivity(new Intent(MainActivity.this, CurrentLocationMap.class));
                break;

            case R.id.details_location:
                startActivity(new Intent(MainActivity.this, DetailsInformationlocation.class));
                break;

            case R.id.locationsearch:
                startActivity(new Intent(MainActivity.this, Locationsearch.class));
                break;

            case R.id.arroundcurrentlocation:
                startActivity(new Intent(MainActivity.this, ArroundCurrentLocation.class));
                break;
        }
    }

    public void displayLocationSettingsRequest(Context context) {

        ///**1st process and easy process**///

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());
        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                Log.d("dddd", "sucsess");
                Toast.makeText(MainActivity.this, "location already Enable", Toast.LENGTH_SHORT).show();
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    try {
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(MainActivity.this,
                                REQUEST_CHECK_SETTINGS);
                        Log.d("dddd", "processing");
                        Toast.makeText(MainActivity.this, "location Enable Processing", Toast.LENGTH_SHORT).show();
                    } catch (IntentSender.SendIntentException sendEx) {

                    }
                }
            }
        });


        ///**another process and large process**///

//        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(context)
//                .addApi(LocationServices.API).build();
//        googleApiClient.connect();
//
//        final LocationRequest locationRequest = LocationRequest.create();
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        locationRequest.setInterval(10000);
//        locationRequest.setFastestInterval(5000);
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
//        builder.setAlwaysShow(true);
//
//        final PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
//        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
//            @Override
//            public void onResult(@NonNull LocationSettingsResult locationSettingsResult) {
//                final Status status = locationSettingsResult.getStatus();
//                switch (status.getStatusCode()) {
//                    case LocationSettingsStatusCodes.SUCCESS:
//                        Toast.makeText(MainActivity.this, "Location is already on", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//                        Toast.makeText(MainActivity.this, "location setting are not satisfied", Toast.LENGTH_SHORT).show();
//                        try {
//                            status.startResolutionForResult(MainActivity.this, REQUEST_CHECK_SETTINGS);
//                        } catch (IntentSender.SendIntentException e) {
//                            Toast.makeText(MainActivity.this, "pendingintent unble to execute request", Toast.LENGTH_SHORT).show();
//                        }
//                        break;
//
//                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                        Toast.makeText(MainActivity.this, "location seeting are inadequate and cannot be fixed here", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//            }
//        });
    }

    public void checkSetting(Context context) {
        boolean isGPSOn = isLocationEnabled(MainActivity.this);
        if (isGPSOn) {
            Toast.makeText(MainActivity.this, "Location On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Location off", Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }
}
