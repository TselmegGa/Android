package com.example.android_node;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText admin, name, description, start, end, pLimit;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //set elements
        admin = findViewById(R.id.txtAdmin);
        name = findViewById(R.id.txtName);
        description = findViewById(R.id.txtDescription);
        start = findViewById(R.id.txtStart);
        end = findViewById(R.id.txtEnd);
        pLimit = findViewById(R.id.txtParticipantsLimit);

        submit = findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
