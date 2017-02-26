package com.example.shan.careemsmartcabs.dao;

/**
 * Created by Shan on 2/26/2017.
 */

public class APIEndpoints {
    // Controller cab engine API Endpoints
    private static String cabEngineBaseURL = "http://localhost:5682/rideengine/webapi";



    public static String getCabEngineBaseURL(){
        return  cabEngineBaseURL;
    }
}
