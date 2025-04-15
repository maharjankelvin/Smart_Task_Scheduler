package com.example.smart_task_scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextCategory, editTextTime, editTextPriority;
    private Button buttonAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Hooking UI components
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextCategory = findViewById(R.id.editTextCategory);
        editTextTime = findViewById(R.id.editTextTime);
        editTextPriority = findViewById(R.id.editTextPriority);
        buttonAddTask = findViewById(R.id.buttonAddTask);

        // Add Task button listener
        buttonAddTask.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString().trim();
            String category = editTextCategory.getText().toString().trim();
            String time = editTextTime.getText().toString().trim();
            String priority = editTextPriority.getText().toString().trim();

            if (title.isEmpty() || category.isEmpty() || time.isEmpty() || priority.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("title", title);
            resultIntent.putExtra("category", category);
            resultIntent.putExtra("time", time);
            resultIntent.putExtra("priority", priority);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}

