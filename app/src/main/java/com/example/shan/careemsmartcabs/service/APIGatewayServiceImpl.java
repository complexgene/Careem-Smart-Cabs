package com.example.shan.careemsmartcabs.service;

import com.example.shan.careemsmartcabs.exceptions.NoCabAvailableExcepion;
import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

import java.util.ArrayList;

/**
 * Created by Shan on 2/25/2017.
 */

public class APIGatewayServiceImpl implements APIGatewayServiceInterface {
    public void ruquestCabBook(String userLat, String userLong, ArrayList<String> possibleCabsBookingList) throws NoCabAvailableExcepion{
        // Broadcast the request to all the users..
    }

    public ArrayList<String> getAllCabsLocationAroundUser(double userLat, double userLong) throws TechnicalException{
        ArrayList<String> allCabsLoc = new ArrayList<>();
        allCabsLoc.add("A, 12.934661, 77.609809");
        allCabsLoc.add("B, 12.930527, 77.617153");
        return  allCabsLoc;
    }
}
