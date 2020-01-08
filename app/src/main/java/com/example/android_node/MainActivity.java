package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_node.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;

    TextView message;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                
            }
        });
    }

    public void register(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}
