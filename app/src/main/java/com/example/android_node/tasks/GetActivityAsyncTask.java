package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.utils.NetworkUtils;

import java.net.URL;

public class GetActivityAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityActivity main;

    public GetActivityAsyncTask(ActivityActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... str) {

        URL url =  NetworkUtils.activityUrl();

        try {
            NetworkUtils.sendGET(url);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String str) {
        //
    }
}
