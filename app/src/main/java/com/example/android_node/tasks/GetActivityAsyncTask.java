package com.example.android_node.tasks;

import android.os.AsyncTask;

import com.example.android_node.ActivityActivity;
import com.example.android_node.models.Activity;
import com.example.android_node.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetActivityAsyncTask extends AsyncTask<String, Void, String> {

    private ActivityActivity main;

    public GetActivityAsyncTask(ActivityActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... str) {

        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.ACTIVITY_URL);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        try {
            response = NetworkUtils.sendGET(url, str[0]);

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String str) {

        ArrayList<Activity> activities = new ArrayList<>();
        try {
            JSONObject j = new JSONObject(str);
            JSONArray jsonArray = j.getJSONArray("result");
            JSONObject json;
            for (int i=0;i<jsonArray.length();i++) {
                json = jsonArray.getJSONObject(i);
                Activity act = new Activity();
                act.setId(json.getInt("id"));
                act.setName(json.getString("name"));
                act.setAdmin(json.getInt("admin_id"));
                act.setDescription(json.getString("description"));
                act.setStartDate(json.getString("starttime"));
                act.setEndDate(json.getString("endtime"));
                act.setMaxParticipant(json.getInt("max"));
                activities.add(act);
            }
            main.linkAdapter(activities);
        } catch(JSONException e){
            e.printStackTrace();
        }
    }
}
