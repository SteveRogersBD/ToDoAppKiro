package com.example.todoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoAdapter.OnTodoClickListener {
    private List<Todo> todos;
    private TodoAdapter adapter;
    private EditText editTextTodo;
    private Button buttonAdd;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerView();
        setupClickListeners();
    }

    private void initViews() {
        editTextTodo = findViewById(R.id.editTextTodo);
        buttonAdd = findViewById(R.id.buttonAdd);
        recyclerView = findViewById(R.id.recyclerView);
        
        todos = new ArrayList<>();
    }

    private void setupRecyclerView() {
        adapter = new TodoAdapter(todos, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setupClickListeners() {
        buttonAdd.setOnClickListener(v -> addTodo());
    }

    private void addTodo() {
        String todoText = editTextTodo.getText().toString().trim();
        
        if (todoText.isEmpty()) {
            Toast.makeText(this, "Please enter a todo item", Toast.LENGTH_SHORT).show();
            return;
        }

        Todo newTodo = new Todo(todoText);
        todos.add(newTodo);
        adapter.notifyItemInserted(todos.size() - 1);
        editTextTodo.setText("");
        
        Toast.makeText(this, "Todo added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTodoToggle(Todo todo) {
        String message = todo.isCompleted() ? "Todo completed!" : "Todo unchecked";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTodoDelete(Todo todo) {
        int position = todos.indexOf(todo);
        if (position != -1) {
            todos.remove(position);
            adapter.notifyItemRemoved(position);
            Toast.makeText(this, "Todo deleted!", Toast.LENGTH_SHORT).show();
        }
    }
}