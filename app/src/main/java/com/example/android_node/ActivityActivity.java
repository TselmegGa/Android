package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_node.models.Activity;
import com.example.android_node.tasks.GetActivityAsyncTask;

import java.util.List;

public class ActivityActivity extends AppCompatActivity implements ActivityOnclickHandler{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int itemId;

    @Override
    public void onActivityClick(View view, int itemIndex) {
        if (view == view.findViewById(R.id.btn_readActivity)){
            Intent i = new Intent(ActivityActivity.this, ActivityReadActivity.class);
            i.putExtra("id", itemIndex);
            startActivity(i);
        }else if (view == view.findViewById(R.id.btn_deleteActivity)){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        //obtain a handle to the object
        mRecyclerView = findViewById(R.id.recycler_view_activity_list);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //connect it to a layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        GetActivityAsyncTask activityAsyncTask = new GetActivityAsyncTask(ActivityActivity.this);
        activityAsyncTask.execute("Get all activities");

        // when task is running, adapter will set the data
        mAdapter = new ActivityRecycleViewAdapter((List<Activity>) activityAsyncTask, this);
        //connect it to the recyclerView
        mRecyclerView.setAdapter(mAdapter);


    }
}
