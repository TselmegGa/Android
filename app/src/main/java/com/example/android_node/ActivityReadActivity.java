package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android_node.models.Activity;
import com.example.android_node.tasks.GetActivityAsyncTask;
import com.example.android_node.tasks.ReadActivityAsyncTask;

import org.json.JSONObject;

public class ActivityReadActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView name;
    TextView description;
    TextView start;
    TextView end;
    TextView limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        final String token = sharedPreferences.getString("token", null);

        name = findViewById(R.id.activity_item_name);
        description = findViewById(R.id.activity_item_description);
        start = findViewById(R.id.activity_item_startDate);
        end = findViewById(R.id.activity_item_endDate);
        limit = findViewById(R.id.activity_item_limit);

        //get activity id
        //set activity data in textview
        Intent intent = getIntent();
        String id = intent.getExtras().get("id").toString();

        //get the data
        ReadActivityAsyncTask readActivityAsyncTask= new ReadActivityAsyncTask(ActivityReadActivity.this);
        readActivityAsyncTask.execute(token, id);

    }

    public void readActivity(Activity activity){
        System.out.println(activity.getName());
        name.setText(activity.getName());
        description.setText(activity.getDescription());
        start.setText(activity.getStartDate());
        end.setText(activity.getEndDate());
        limit.setText("" + activity.getMaxParticipant());
    }
}
