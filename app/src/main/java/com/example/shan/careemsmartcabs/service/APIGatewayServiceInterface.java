package com.example.shan.careemsmartcabs.service;

import com.example.shan.careemsmartcabs.exceptions.NoCabAvailableExcepion;
import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shan on 2/25/2017.
 */

public interface APIGatewayServiceInterface {
    void ruquestCabBook(String userLat, String userLong, ArrayList<String> possibleCabsBookingList) throws NoCabAvailableExcepion;
    ArrayList<String> getAllCabsLocationAroundUser(double userLat, double userLong) throws TechnicalException;
}
