package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.utils.NetworkUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AddParticipantAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityActivity main;

    public AddParticipantAsyncTask(ActivityActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.ACTIVITY_URL + "/" + strings[2] + "/" + NetworkUtils.PARTICIPANT_URL);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendPOSTWithToken(url, strings[0], strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
