package com.example.shan.careemsmartcabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapHolder extends AppCompatActivity implements OnMapReadyCallback{
    private static GoogleMap mMap;
    private Double lati, longi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_holder);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.cab_map);
        mapFragment.getMapAsync(this);

        String location = getIntent().getExtras().get("userloc").toString();
        Log.e("MapHolder", location);
        lati = Double.parseDouble(location.split(",")[0]);
        longi = Double.parseDouble(location.split(",")[1]);

    }

    void newLatLong(LatLng newLoc){
        mMap.addMarker(new MarkerOptions().position(newLoc).title("User"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newLoc));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        //int lat =
        LatLng sydney = new LatLng(lati, longi);
        mMap.setMinZoomPreference(15.0f);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
