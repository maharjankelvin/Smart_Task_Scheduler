package com.example.smart_task_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskAdapter adapter;
    private static final int ADD_TASK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList);

        RecyclerView recyclerView = findViewById(R.id.recyclerTasks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fabAddTask);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(TaskListActivity.this, AddTaskActivity.class);
            startActivityForResult(intent, ADD_TASK_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_TASK_REQUEST && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String category = data.getStringExtra("category");
            String time = data.getStringExtra("time");
            String priorityString = data.getStringExtra("priority"); // It's likely coming as a String from EditText
            String deadline = data.getStringExtra("deadline"); // You need to pass this from AddTaskActivity

            int priority = 0;
            try {
                priority = Integer.parseInt(priorityString);
            } catch (NumberFormatException e) {
                // Handle the case where the priority is not a valid number
                e.printStackTrace();
                // You might want to set a default priority or show an error message
            }

            taskList.add(new Task(title, category, priority, deadline, time));
            adapter.notifyItemInserted(taskList.size() - 1);
        }
    }
    }
