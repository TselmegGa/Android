package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.MainActivity;
import com.example.android_node.utils.NetworkUtils;

import java.net.URL;

public class LogInAsyncTask extends AsyncTask<String, Void, String> {

    private MainActivity main;

    public LogInAsyncTask(MainActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... str) {

        URL url =  NetworkUtils.loginUrl();

        try {
            NetworkUtils.sendPOST(url, str[0]);

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
