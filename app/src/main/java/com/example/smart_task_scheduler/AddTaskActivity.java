package com.example.smart_task_scheduler;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTaskTitle, editPriority;
    private Spinner spinnerCategory, spinnerTaskType;
    private Button btnPickDeadline, btnSaveTask;
    private Switch switchReminder;

    private String selectedDeadline = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Initialize views
        editTaskTitle = findViewById(R.id.editTaskTitle);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerTaskType = findViewById(R.id.spinnerTaskType);
        editPriority = findViewById(R.id.editPriority);
        btnPickDeadline = findViewById(R.id.btnPickDeadline);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        switchReminder = findViewById(R.id.switchReminder);

        // Sample Spinner Setup (you can load from strings.xml or database)
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.category_options, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        ArrayAdapter<CharSequence> taskTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.task_type_options, android.R.layout.simple_spinner_item);
        taskTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTaskType.setAdapter(taskTypeAdapter);

        // Date Picker Dialog for Deadline
        btnPickDeadline.setOnClickListener(view -> {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(this, (view1, year1, month1, dayOfMonth) -> {
                selectedDeadline = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                btnPickDeadline.setText("Deadline: " + selectedDeadline);
            }, year, month, day);

            dialog.show();
        });

        // Save Task button logic
        btnSaveTask.setOnClickListener(v -> {
            String title = editTaskTitle.getText().toString().trim();
            String category = spinnerCategory.getSelectedItem().toString();
            String taskType = spinnerTaskType.getSelectedItem().toString();
            String priority = editPriority.getText().toString().trim();
            boolean reminderSet = switchReminder.isChecked();

            if (title.isEmpty() || priority.isEmpty() || selectedDeadline.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("title", title);
            resultIntent.putExtra("category", category);
            resultIntent.putExtra("taskType", taskType);
            resultIntent.putExtra("priority", priority);
            resultIntent.putExtra("deadline", selectedDeadline);
            resultIntent.putExtra("reminder", reminderSet);

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
