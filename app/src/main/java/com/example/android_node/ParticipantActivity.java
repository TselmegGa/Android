package com.example.android_node;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_node.models.Activity;
import com.example.android_node.models.User;
import com.example.android_node.tasks.GetActivityAsyncTask;
import com.example.android_node.tasks.GetParticipantAsyncTask;

import java.util.List;

public class ParticipantActivity extends AppCompatActivity implements ParticipantOnclickHandler {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participant_list_view);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);

        //obtain a handle to the object
        mRecyclerView = findViewById(R.id.recycler_view_participant_list);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        //connect it to a layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);
        Intent intent = getIntent();
        String id = intent.getExtras().get("id").toString();
        // specify an adapter
        GetParticipantAsyncTask activityAsyncTask = new GetParticipantAsyncTask(ParticipantActivity.this);
        activityAsyncTask.execute(token, id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_participant_list, menu);
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

    public void linkAdapter(List<User> users) {
        // when task is running, adapter will set the data
        mAdapter = new ParticipantRecycleViewAdapter(users, this);
        //connect it to the recyclerView
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityClick(View view, int itemIndex) {

        if (view == view.findViewById(R.id.btn_readUser)) {
            Intent i = new Intent(ParticipantActivity.this, ActivityReadActivity.class);
            i.putExtra("id", itemIndex);
            startActivity(i);
        }
        if (view == view.findViewById(R.id.btn_getParticipants)) {
            Intent i = new Intent(ParticipantActivity.this, ActivityReadActivity.class);
            i.putExtra("id", itemIndex);
            startActivity(i);
        }
    }
}
