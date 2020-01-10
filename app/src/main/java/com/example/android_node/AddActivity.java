package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_node.tasks.CreateActivityAsyncTask;
import com.example.android_node.tasks.RegisterAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

public class AddActivity extends AppCompatActivity {

    EditText name, description, start, end, pLimit;
    SharedPreferences sharedPreferences;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        final String token = sharedPreferences.getString("token", null);

        //set elements
        name = findViewById(R.id.txtName);
        description = findViewById(R.id.txtDescription);
        start = findViewById(R.id.txtStart);
        end = findViewById(R.id.txtEnd);
        pLimit = findViewById(R.id.txtParticipantsLimit);

        submit = findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String activityName = name.getText().toString();
                String activityDescription = description.getText().toString();
                String activityStart = start.getText().toString();
                String activityEnd = end.getText().toString();
                String activityLimit = pLimit.getText().toString();
                String jsonString = null;

                try {
                    jsonString = new JSONObject()
                            .put("name", activityName)
                            .put("description", activityDescription)
                            .put("startDate", activityStart)
                            .put("endDate", activityEnd)
                            .put("particopationLimit", activityLimit).toString();
                } catch(org.json.JSONException e) {
                    throw new RuntimeException(e);
                }
                CreateActivityAsyncTask task = new CreateActivityAsyncTask(AddActivity.this);
                task.execute(jsonString, token);
            }
        });
    }
}
