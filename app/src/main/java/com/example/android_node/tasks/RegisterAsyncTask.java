package com.example.android_node.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.android_node.MainActivity;

import com.example.android_node.RegisterActivity;
import com.example.android_node.utils.NetworkUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RegisterAsyncTask extends AsyncTask<String, Void, String>{

    private RegisterActivity main;

    public RegisterAsyncTask(RegisterActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... str) {
        URL url = null;
        String response = null;
        try {
            url = new URL(NetworkUtils.BASE_URL + NetworkUtils.REGISTER_URL);
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
        if(str.equals("POST Failed")){
            //
        }else {
            main.main();

        }
    }
}
