package com.example.shan.careemsmartcabs.service;

import android.location.Location;
import android.util.Log;

import com.example.shan.careemsmartcabs.dao.APIEndpoints;
import com.example.shan.careemsmartcabs.dao.MyEventListener;
import com.example.shan.careemsmartcabs.exceptions.NoCabAvailableExcepion;
import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Shan on 2/25/2017.
 */

public class APIGatewayServiceImpl implements APIGatewayServiceInterface,MyEventListener {

    FireHttpService fireHttp = new FireHttpService();

    public void ruquestCabBook(String userLat, String userLong, ArrayList<String> possibleCabsBookingList) throws NoCabAvailableExcepion{
        // Broadcast the request to all the users..
    }

    @Override
    public void onEventCompleted() {

    }

    @Override
    public void onEventFailed() {

    }

    public ArrayList<String> getAllCabsLocationAroundUser(double userLat, double userLong) throws TechnicalException {
        ArrayList<String> allCabsLoc = new ArrayList<>();
        try {
            /*URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng="+ userLat + "," + userLong + "&sensor=false");
            String reverseGEOLocation = fireHttp.callHttpGET(url);
            */String countryCode = "IN", stateCode = "KA", cityCode = "BLR";

            // Firing mapping service endpoint to get the nearest cabs.
            URL url = new URL(APIEndpoints.getCabEngineBaseURL()+"/mappingservice/nearbycabs?user_countrycode="+countryCode+"&user_statecode="+stateCode+"&" +
                    "user_citycode="+cityCode+"&user_latitude="+userLat+"&user_longitude="+userLong);


            int rand1=new Random().nextInt(100),rand2=new Random().nextInt(100);
            String val1 = "A,"+"12.9341"+rand1+",77.6093"+rand2;
            rand1=new Random().nextInt(100);rand2=new Random().nextInt(100);
            String val2 = "B,"+"12.9303"+rand1+",77.6172"+rand2;
            rand1=new Random().nextInt(100);rand2=new Random().nextInt(100);
            String val3 = "C,"+"12.9323"+rand1+",77.6162"+rand2;
            rand1=new Random().nextInt(100);rand2=new Random().nextInt(100);
            String val4 = "A,"+"12.9298"+rand1+",77.6054"+rand2;
            allCabsLoc.add(val1);
            allCabsLoc.add(val2);
            allCabsLoc.add(val3);
            allCabsLoc.add(val4);

            // Filter the nearest ones
            /*ArrayList<Double> sortedDistances = new ArrayList<>(allCabsLoc.size());

            for(String eachPos : allCabsLoc){
                sortedDistances.add(getDistanceInMetres(userLat+","+userLong,eachPos.substring(eachPos.indexOf(","))));
            }
            Collections.sort(sortedDistances);
            if(sortedDistances.size()>10)return (ArrayList<String>)allCabsLoc.subList(0,10);
*/
        } catch (IOException ee) {
            throw new RuntimeException(ee);
        }
        return allCabsLoc;
    }

    double getDistanceInMetres(String lc1, String lc2){
        Location loc1 = new Location("");
        loc1.setLatitude(Double.parseDouble(lc1.split(",")[0]));
        loc1.setLongitude(Double.parseDouble(lc1.split(",")[1]));

        Location loc2 = new Location("");
        loc2.setLatitude(Double.parseDouble(lc2.split(",")[0]));
        loc2.setLongitude(Double.parseDouble(lc2.split(",")[1]));

        float distanceInMeters = loc1.distanceTo(loc2);
        return  distanceInMeters;
    }
}
/*
int rand1=new Random().nextInt(100),rand2=new Random().nextInt(100);
        String val1 = "A,"+"12.9341"+rand1+",77.6093"+rand2;
        rand1=new Random().nextInt(100);rand2=new Random().nextInt(100);
        String val2 = "B,"+"12.9303"+rand1+",77.6172"+rand2;
        rand1=new Random().nextInt(100);rand2=new Random().nextInt(100);
        String val3 = "C,"+"12.9323"+rand1+",77.6162"+rand2;
        rand1=new Random().nextInt(100);rand2=new Random().nextInt(100);
        String val4 = "A,"+"12.9298"+rand1+",77.6054"+rand2;
        Log.e("Gateway",val3+" "+val4);
 */