package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> todos;
    private OnTodoClickListener listener;

    public interface OnTodoClickListener {
        void onTodoToggle(Todo todo);
        void onTodoDelete(Todo todo);
    }

    public TodoAdapter(List<Todo> todos, OnTodoClickListener listener) {
        this.todos = todos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.bind(todo);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CheckBox checkBox;
        private ImageButton deleteButton;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.todoText);
            checkBox = itemView.findViewById(R.id.todoCheckbox);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }

        public void bind(Todo todo) {
            textView.setText(todo.getText());
            checkBox.setChecked(todo.isCompleted());
            
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                todo.setCompleted(isChecked);
                if (listener != null) {
                    listener.onTodoToggle(todo);
                }
            });

            deleteButton.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onTodoDelete(todo);
                }
            });
        }
    }
}