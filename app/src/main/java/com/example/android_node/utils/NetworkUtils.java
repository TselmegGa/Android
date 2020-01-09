package com.example.android_node.utils;
import android.net.Uri;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public final class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();
    private static final String BASE_URL = "http://localhost:3000/";
    private static final String ACTIVITY_URL = "api/activities";
    private static final String lOGIN_URL = "api/login";
    private static final String REGISTER_URL = "api/register";

    public static URL loginUrl() {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(lOGIN_URL)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static URL registerUrl() {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(REGISTER_URL)
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
    public static void sendGET(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
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
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }

    public static void sendPOST(URL url, String params) throws IOException {

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(params.getBytes());
        os.flush();
        os.close();
        // For POST only - END

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
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }

}
