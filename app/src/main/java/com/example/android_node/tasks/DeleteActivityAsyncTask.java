package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.utils.NetworkUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteActivityAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityActivity main;

    public DeleteActivityAsyncTask(ActivityActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.DELETEACTIVITY_URL);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendDelete(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
