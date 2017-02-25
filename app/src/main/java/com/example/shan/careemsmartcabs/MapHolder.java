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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapHolder extends AppCompatActivity implements OnMapReadyCallback{
    private static GoogleMap mMap;
    private Double lati, longi;
    ArrayList<String> allCabsLocation = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_holder);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.cab_map);
        mapFragment.getMapAsync(this);

        String location = getIntent().getExtras().get("userloc").toString();
        lati = Double.parseDouble(location.split(",")[0]);
        longi = Double.parseDouble(location.split(",")[1]);
        allCabsLocation = getIntent().getExtras().getStringArrayList("allcabsloc");
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
        LatLng userLatLng = new LatLng(lati, longi);
        mMap.setMinZoomPreference(15.0f);
        mMap.addMarker(new MarkerOptions().position(userLatLng).title("Sydney"));
        for(String eachCabLoc : allCabsLocation){
            LatLng cabLoc = new LatLng(Double.parseDouble(eachCabLoc.split(",")[1]),Double.parseDouble(eachCabLoc.split(",")[2]));
            char cabType = eachCabLoc.split(",")[0].charAt(0);
            BitmapDescriptor bd = null;
            switch(cabType){
                case 'A' :{
                    bd = BitmapDescriptorFactory.fromResource(R.drawable.cab);
                    break;
                }
                case 'B':{
                    bd = BitmapDescriptorFactory.fromResource(R.drawable.cab_mini);
                }
            }
            mMap.addMarker(new MarkerOptions().position(cabLoc).title("cab").icon(bd));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLatLng));
    }
}
