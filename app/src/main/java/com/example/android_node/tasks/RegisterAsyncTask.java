package com.example.android_node.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.android_node.MainActivity;

import com.example.android_node.RegisterActivity;
import com.example.android_node.utils.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

public class RegisterAsyncTask extends AsyncTask<String, Void, String>{

    private RegisterActivity main;

    public RegisterAsyncTask(RegisterActivity main) {
        this.main = main;
    }

    @Override
    protected String doInBackground(String... str) {

        URL url =  NetworkUtils.registerUrl();

        try {
            NetworkUtils.sendPOST(url, str[0]);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String str) {
    //
    }
}
