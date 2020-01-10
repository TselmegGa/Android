package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_node.models.User;
import com.example.android_node.tasks.RegisterAsyncTask;

import org.json.JSONObject;
public class RegisterActivity extends AppCompatActivity {

    private EditText firstname, lastname, email, password, place;

    private Button createUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //create gui-objects
        firstname = findViewById(R.id.input_firstname);
        lastname = findViewById(R.id.input_lastname);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        place = findViewById(R.id.input_place);

        createUser = findViewById(R.id.btn_register);

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userFirstname = firstname.getText().toString();
                String userLastname = lastname.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                String userPlace = place.getText().toString();
                String jsonString = null;
                try {
                     jsonString = new JSONObject()
                            .put("firstname", userFirstname)
                            .put("lastname", userLastname)
                            .put("email", userEmail)
                            .put("password", userPassword)
                            .put("location", userPlace).toString();
                } catch(org.json.JSONException e) {
                    throw new RuntimeException(e);
                }



                RegisterAsyncTask task = new RegisterAsyncTask(RegisterActivity.this);
                task.execute(jsonString);
            }
        });

    }

    public void back(View view) {
        // kills activity and takes user to mainactivity
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }
    public void main() {
        // kills activity and takes user to mainactivity
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }
}
