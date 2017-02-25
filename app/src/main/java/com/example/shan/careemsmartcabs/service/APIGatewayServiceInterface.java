package com.example.shan.careemsmartcabs.service;

import com.example.shan.careemsmartcabs.exceptions.NoCabAvailableExcepion;
import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

/**
 * Created by Shan on 2/25/2017.
 */

public interface APIGatewayServiceInterface {
    void ruquestCabBook() throws NoCabAvailableExcepion;
    String getUserCurrentLocation() throws TechnicalException;
}
