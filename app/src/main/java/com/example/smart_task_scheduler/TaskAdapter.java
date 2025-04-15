package com.example.smart_task_scheduler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvCategory, tvTime, tvPriority;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvPriority = itemView.findViewById(R.id.tvPriority);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.tvTitle.setText(task.getTitle());
        holder.tvCategory.setText("Category: " + task.getCategory());
        holder.tvTime.setText("Time: " + task.getTime());
        holder.tvPriority.setText("Priority: " + task.getPriority());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
