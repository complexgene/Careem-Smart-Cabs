package com.example.shan.careemsmartcabs;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shan.careemsmartcabs.model.User;
import com.example.shan.careemsmartcabs.service.APIGatewayServiceImpl;
import com.example.shan.careemsmartcabs.service.APIGatewayServiceInterface;
import com.example.shan.careemsmartcabs.service.GPSTracker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = android.Manifest.permission.ACCESS_FINE_LOCATION;

    APIGatewayServiceInterface serviceBot = new APIGatewayServiceImpl();
    User singleTonUser = User.getInstance();

    GPSTracker gps;
    double userLatitude, userLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askForLocationPermission();

        Button btn_bookCab = (Button)findViewById(R.id.bookride);
        btn_bookCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gps = new GPSTracker(MainActivity.this);
                if(gps.canGetLocation()){
                    userLatitude = gps.getLatitude();
                    userLongitude = gps.getLongitude();
                }else{
                    gps.showSettingsAlert();
                }
                ArrayList<String> nearByCabLocations = serviceBot.getAllCabsLocationAroundUser(userLatitude,userLongitude);

                Intent ii = new Intent(MainActivity.this, MapHolder.class);
                ii.putExtra("userloc",userLatitude+","+userLongitude);
                for(int i=0;i<nearByCabLocations.size();i++){
                    ii.putStringArrayListExtra("allcabsloc",nearByCabLocations);
                }
                startActivity(ii);
            }
        });
    }

    void askForLocationPermission(){
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will
                // execute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
