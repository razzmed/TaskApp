package com.example.taskapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.taskapp.models.Task;

public class FormActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editDesc;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("New Task");
        }

        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
        edit();

    }

    public void edit() {
        task = (Task) getIntent().getSerializableExtra("task");
        if (task != null) {
            editTitle.setText(task.getTitle());
            editDesc.setText(task.getDesc());
        }
    }

    public void onClick (View view) {
        if (task != null) {
            task.setTitle(editTitle.getText().toString());
            task.setDesc(editDesc.getText().toString());
            App.getInstance().getDatabase().taskDao().update(task);
        } else {
            task = new Task(editTitle.getText().toString(), editDesc.getText().toString());
            App.getInstance().getDatabase().taskDao().update(task);
        }
        finish();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setResult(RESULT_CANCELED);
        finish();
        return true;
    }

}
