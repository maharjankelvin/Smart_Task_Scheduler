package com.example.smart_task_scheduler;

public class Task {
    private String title;
    private String category;
    private int priority;
    private String deadline;

    public Task(String title, String category, int priority, String deadline) {
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public int getPriority() { return priority; }
    public String getDeadline() { return deadline; }
}
