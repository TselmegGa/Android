package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityReadActivity;
import com.example.android_node.models.Activity;
import com.example.android_node.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReadActivityAsyncTask extends AsyncTask<String, Void, String> {
    private ActivityReadActivity main;
    private JSONObject jsonActcity;

    public ReadActivityAsyncTask(ActivityReadActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.ACTIVITY_URL + "/" + strings[1]);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendGET(url, strings[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String str) {

        try {
            JSONObject j = new JSONObject(str);
            System.out.println(j.toString());
            JSONArray jsonArray = j.getJSONArray("result");
            JSONObject json;
            json = jsonArray.getJSONObject(0);
            Activity act = new Activity();
            act.setId(json.getInt("id"));
            act.setName(json.getString("name"));
            act.setAdmin(json.getInt("admin_id"));
            act.setDescription(json.getString("description"));
            act.setStartDate(json.getString("starttime"));
            act.setEndDate(json.getString("endtime"));
            act.setMaxParticipant(json.getInt("max"));
            main.readActivity(act);
        } catch(JSONException e){
            e.printStackTrace();
        }
    }
}
