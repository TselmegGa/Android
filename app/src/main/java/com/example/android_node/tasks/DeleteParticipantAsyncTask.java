package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.utils.NetworkUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteParticipantAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityActivity main;

    public DeleteParticipantAsyncTask(ActivityActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.ACTIVITY_URL + "/" + strings[1] + "/" + NetworkUtils.PARTICIPANT_URL + "/" + strings[2]);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendDelete(url, strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
