package com.example.shan.careemsmartcabs.service;

import com.example.shan.careemsmartcabs.exceptions.NoCabAvailableExcepion;
import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

/**
 * Created by Shan on 2/25/2017.
 */

public class APIGatewayServiceImpl implements APIGatewayServiceInterface {
    public void ruquestCabBook() throws NoCabAvailableExcepion{
        String userLocation = getUserCurrentLocation();

    }
    public String getUserCurrentLocation() throws TechnicalException{
        return "";
    }
}
