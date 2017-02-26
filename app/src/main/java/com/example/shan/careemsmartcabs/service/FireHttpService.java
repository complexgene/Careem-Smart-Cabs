package com.example.shan.careemsmartcabs.service;

import android.util.Log;

import com.example.shan.careemsmartcabs.exceptions.TechnicalException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Shan on 2/26/2017.
 */

public class FireHttpService {
     public String callHttpGET(URL url){
        StringBuffer response = new StringBuffer();
        try{
            HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
            int responseCode = httpConnection.getResponseCode();
            if(responseCode==200){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpConnection.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            }
            else{
                response.append("Nothing's here");
            }

        }
        catch(Exception ee){
            Log.e("FireHttp",ee.getMessage());
        }
        return response.toString();
    }
}
