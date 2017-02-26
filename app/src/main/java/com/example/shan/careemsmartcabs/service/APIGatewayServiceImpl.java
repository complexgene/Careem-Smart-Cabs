package com.example.shan.careemsmartcabs.service;

import android.util.Log;

import com.example.shan.careemsmartcabs.dao.APIEndpoints;
import com.example.shan.careemsmartcabs.exceptions.NoCabAvailableExcepion;
import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Shan on 2/25/2017.
 */

public class APIGatewayServiceImpl implements APIGatewayServiceInterface {

    FireHttpService fireHttp = new FireHttpService();

    public void ruquestCabBook(String userLat, String userLong, ArrayList<String> possibleCabsBookingList) throws NoCabAvailableExcepion{
        // Broadcast the request to all the users..
    }

    public ArrayList<String> getAllCabsLocationAroundUser(double userLat, double userLong) throws TechnicalException {
        ArrayList<String> allCabsLoc = new ArrayList<>();
        try {
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + userLat + "," + userLong + "&sensor=false");
            String reverseGEOLocation = fireHttp.callHttpGET(url);
            JSONObject jsonObject = new JSONObject(reverseGEOLocation);
            jsonObject.getJSONArray("results");
            jsonObject.getJSONArray("address_components");
            Log.e("APIGateway12", jsonObject.get("short_name").toString());

            /*allCabsLoc.add(val1);
            allCabsLoc.add(val2);
            allCabsLoc.add(val3);
            allCabsLoc.add(val4);
            */
        } catch (Exception ee) {
            Log.e("APIGateway", "malformed URL:"+ee.getMessage());
        }
        return allCabsLoc;
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