package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_node.models.User;
import com.example.android_node.tasks.LogInAsyncTask;
import com.example.android_node.tasks.RegisterAsyncTask;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    SharedPreferences sharedPreferences;
    TextView message;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        //create elements
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);

        logIn = findViewById(R.id.btn_login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // compare the values with database values to log in if it is a match
                String userMail = email.getText().toString();
                String userPassword = password.getText().toString();

                //send data to log in
                String jsonString = null;
                try {
                    jsonString = new JSONObject()
                            .put("email", userMail)
                            .put("password", userPassword).toString();
                } catch(org.json.JSONException e) {
                    throw new RuntimeException(e);
                }
                LogInAsyncTask task = new LogInAsyncTask(MainActivity.this);
                task.execute(jsonString);

                // when task is running then start next actvitiy

            }
        });
    }

    public void storeToken(String response){
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("token", response);
        myEdit.apply();
    }

    public void register(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void login(){
        Intent i = new Intent(MainActivity.this, ActivityActivity.class);
        startActivity(i);
    }
}
