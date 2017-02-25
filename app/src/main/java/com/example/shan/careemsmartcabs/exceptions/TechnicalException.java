package com.example.shan.careemsmartcabs.exceptions;

import android.util.Log;

/**
 * Created by Shan on 2/25/2017.
 */

public class TechnicalException extends RuntimeException {
    TechnicalException(String module, String errorMsg){
        super(errorMsg);
        Log.e(module, errorMsg);
    }
}
