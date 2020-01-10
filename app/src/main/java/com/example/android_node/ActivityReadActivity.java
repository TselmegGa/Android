package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.android_node.tasks.GetActivityAsyncTask;
import com.example.android_node.tasks.ReadActivityAsyncTask;

public class ActivityReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        //get activity id
        //set activity data in textview
        Intent intent = getIntent();
        intent.getExtras().get("id");

        //get the data
        ReadActivityAsyncTask readActivityAsyncTask= new ReadActivityAsyncTask(ActivityReadActivity.this);
        readActivityAsyncTask.execute("Get one activity");
    }
}
