package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.ActivityReadActivity;
import com.example.android_node.utils.NetworkUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdateActivityAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityReadActivity main;

    public UpdateActivityAsyncTask(ActivityReadActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.ACTIVITY_URL + "/" + strings[2]);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendPUT(url, strings[0], strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        main.startNextActivity();
    }
}
