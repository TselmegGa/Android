package com.example.android_node.utils;
import android.net.Uri;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class NetworkUtils {
    public static final String TAG = NetworkUtils.class.getSimpleName();
    public static final String BASE_URL = "https://who-is-going.herokuapp.com/api/";
    public static final String ACTIVITY_URL = "activities";
    public static final String LOGIN_URL = "login";
    public static final String REGISTER_URL = "register";
    public static final String READACTIVITY_URL = "activities/:id";
    public static final String DELETEACTIVITY_URL = "activities/:id";


    public static URL activityUrl() {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(ACTIVITY_URL)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static URL deleteActivityUrl() {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(DELETEACTIVITY_URL)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static URL readActivityUrl() {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(READACTIVITY_URL)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    //getreq
    public static String sendGET(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiZmlyc3RfbmFtZSI6ImJvYiIsImxhc3RfbmFtZSI6InRvbSIsImVtYWlsIjoidG9tQHRvbS5jb20iLCJwYXNzd29yZCI6IjEyMzQ1NiIsImxvY2F0aW9uIjoiYm9zdG9uIiwiaWF0IjoxNTc4NjcwODg5LCJleHAiOjE1Nzg2NzQ0ODl9.QnyeP8oGdHpingdepuKRyJogKTDWGhbGQ6uiVidbpsQ");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            return "GET request not worked";
        }

    }

    public static String sendDelete (URL url) throws IOException{
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        int responseCode = con.getResponseCode();
        System.out.println("Delete Response Code :: " + responseCode);

        con.connect();

        // For POST only - END
        System.out.println("POST url:: " + url);
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            return "POST Failed";
        }
    }

    public static String sendPOST(URL url, String params) throws IOException {

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(params.getBytes());
        os.flush();
        os.close();
        // For POST only - END
        System.out.println("POST url:: " + url);
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            return "POST Failed";
        }
    }



}
