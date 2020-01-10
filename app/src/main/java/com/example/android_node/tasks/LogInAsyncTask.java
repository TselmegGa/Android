package com.example.android_node.tasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.example.android_node.MainActivity;
import com.example.android_node.utils.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class LogInAsyncTask extends AsyncTask<String, Void, String> {

    private MainActivity main;

    public LogInAsyncTask(MainActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... str) {

        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.LOGIN_URL);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendPOST(url, str[0]);

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String str) {
        String token = null;
        try {
            JSONObject json = new JSONObject(str);
            token = json.getString("token");
        } catch(JSONException e){
            e.printStackTrace();
        }
        System.out.println("POST Response Code :: " + token);
        main.storeToken(token);
        //
    }
}
