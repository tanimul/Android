package com.example.google_maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SimpleMapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.simple_mapinit);
        mapFragment.getMapAsync(SimpleMapActivity.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng bdbasurhat = new LatLng(22.867805, 91.273210);
        googleMap.addMarker(new MarkerOptions().position(bdbasurhat).title("Bashurhat"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bdbasurhat, 15f));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(bdbasurhat));

    }
}
