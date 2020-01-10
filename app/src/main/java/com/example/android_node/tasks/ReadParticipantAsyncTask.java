package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.models.User;
import com.example.android_node.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReadParticipantAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityActivity main;

    public ReadParticipantAsyncTask(ActivityActivity main) {
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
            response = NetworkUtils.sendGET(url, strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
    @Override
    protected void onPostExecute(String str) {
        ArrayList<User> users = new ArrayList<>();
        try {
            JSONObject j = new JSONObject(str);
            JSONArray jsonArray = j.getJSONArray("result");
            JSONObject json;
            json = jsonArray.getJSONObject(0);
            User user = new User(json.getString("first_name"), json.getString("last_name"),
                        json.getString("email"), json.getString("location"));
            users.add(user);

        } catch(JSONException e){
            e.printStackTrace();
        }
    }
}
