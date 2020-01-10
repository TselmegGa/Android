package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityReadActivity;
import com.example.android_node.utils.NetworkUtils;

import java.net.URL;

public class ReadActivityAsyncTask extends AsyncTask<String, Void, String> {
    private ActivityReadActivity main;

    public ReadActivityAsyncTask(ActivityReadActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url =  NetworkUtils.readActivityUrl();

        try {
            NetworkUtils.sendGET(url);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        // do something with data
    }
}
