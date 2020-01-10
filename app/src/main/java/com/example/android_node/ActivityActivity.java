package com.example.android_node;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android_node.models.Activity;
import com.example.android_node.tasks.DeleteActivityAsyncTask;
import com.example.android_node.tasks.GetActivityAsyncTask;

import java.util.List;

public class ActivityActivity extends AppCompatActivity implements ActivityOnclickHandler {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);

        //obtain a handle to the object
        mRecyclerView = findViewById(R.id.recycler_view_activity_list);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //connect it to a layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        GetActivityAsyncTask activityAsyncTask = new GetActivityAsyncTask(ActivityActivity.this);
        activityAsyncTask.execute(token);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activities_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_activity:

                    Intent intent = new Intent(this, AddActivity.class);
                    startActivity(intent);

                return true;
            case R.id.sign_out:

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);

                //remove token
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("token");
                editor.apply();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void linkAdapter(List<Activity> activities) {
        // when task is running, adapter will set the data
        mAdapter = new ActivityRecycleViewAdapter(activities, this);
        //connect it to the recyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityClick(View view, int itemIndex) {

        if (view == view.findViewById(R.id.btn_readActivity)) {
            Intent i = new Intent(ActivityActivity.this, ActivityReadActivity.class);
            i.putExtra("id", itemIndex);
            startActivity(i);
        }else if (view == view.findViewById(R.id.btn_deleteActivity)){
            System.out.println("delete");
            sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            String token = sharedPreferences.getString("token", null);

            DeleteActivityAsyncTask remove = new DeleteActivityAsyncTask(this);
            remove.execute(token, "" + itemIndex);
        }
    }
}
