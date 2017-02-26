package com.example.shan.careemsmartcabs.dao;

import android.os.AsyncTask;

/**
 * Created by Shan on 2/26/2017.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private MyEventListener callback;

    public MyAsyncTask(MyEventListener cb) {
        callback = cb;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(callback != null) {
            callback.onEventCompleted();
        }
    }
}