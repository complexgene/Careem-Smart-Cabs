package com.example.shan.careemsmartcabs.exceptions;

import android.util.Log;

/**
 * Created by Shan on 2/25/2017.
 */

public class NoCabAvailableExcepion extends RuntimeException {
    NoCabAvailableExcepion(String generatedFromModule, String errorMsg){
        super(errorMsg);
        Log.e(generatedFromModule, errorMsg);
    }
}
