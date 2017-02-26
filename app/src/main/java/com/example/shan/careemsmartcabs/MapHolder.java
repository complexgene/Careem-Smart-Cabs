package com.example.shan.careemsmartcabs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.shan.careemsmartcabs.service.APIGatewayServiceImpl;
import com.example.shan.careemsmartcabs.service.APIGatewayServiceInterface;
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

        Button microCab = (Button)findViewById(R.id.cab_micro),
                miniCab = (Button)findViewById(R.id.cab_mini),
                sedanCab = (Button)findViewById(R.id.cab_sedan);
        microCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pd = ProgressDialog.show(MapHolder.this,"Booking a Micro","Wait while we book a micro for you.");
                pd.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                pd.dismiss();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Your location Lat:"+lati+" and Long:"+longi+" has been sent to server for nearest cab booking..",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }).start();
                    }
                },2000);
            }
        });
        miniCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pd = ProgressDialog.show(MapHolder.this,"Booking a Mini","Wait while we book a mini for you.");
                pd.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                pd.dismiss();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Your location Lat:"+lati+" and Long:"+longi+" has been sent to server for nearest cab booking..",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }).start();
                    }
                },2000);
            }
        });
        sedanCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pd = ProgressDialog.show(MapHolder.this,"Booking a Sedan","Wait while we book a sedan for you.");
                pd.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                pd.dismiss();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Your location Lat:"+lati+" and Long:"+longi+" has been sent to server for nearest cab booking..",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }).start();
                    }
                },2000);
            }
        });
    }
    APIGatewayServiceInterface serviceBot = new APIGatewayServiceImpl();
    void newLatLong(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mMap.clear();
                                LatLng userLatLng = new LatLng(lati, longi);
                                mMap.setMinZoomPreference(15.0f);
                                mMap.addMarker(new MarkerOptions().position(userLatLng).title("Sydney"));
                                allCabsLocation = serviceBot.getAllCabsLocationAroundUser(lati,longi);
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
                                            break;
                                        }
                                        case 'C':{
                                            bd = BitmapDescriptorFactory.fromResource(R.drawable.cab_sedan);
                                        }
                                    }
                                    mMap.addMarker(new MarkerOptions().position(cabLoc).title("cab").icon(bd));
                                }
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLatLng));
                            }
                        });
                    }
                }).start();
                newLatLong();
            }
        },150);
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
        newLatLong();
    }
}
