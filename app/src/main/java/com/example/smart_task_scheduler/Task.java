package com.example.smart_task_scheduler;

public class Task {
    private String title;
    private String category;
    private int priority;
    private String deadline;
    private String time; // Added field for time

    public Task(String title, String category, int priority, String deadline, String time) {
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.time = time; // Initialize the time field
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public int getPriority() { return priority; }
    public String getDeadline() { return deadline; }
    public String getTime() { return time; } // Added getter for time

    // Optional: Add setter for time if you need to modify it later
    public void setTime(String time) { this.time = time; }
}