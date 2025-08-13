package com.example.todobackend.service;

import com.example.todobackend.dto.TodoRequest;
import com.example.todobackend.dto.TodoResponse;
import com.example.todobackend.exception.TodoNotFoundException;
import com.example.todobackend.model.Todo;
import com.example.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }

    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
        return new TodoResponse(todo);
    }

    public TodoResponse createTodo(TodoRequest request) {
        Todo todo = new Todo(request.getText());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponse(savedTodo);
    }

    public TodoResponse updateTodo(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
        
        todo.setText(request.getText());
        Todo updatedTodo = todoRepository.save(todo);
        return new TodoResponse(updatedTodo);
    }

    public TodoResponse toggleTodoCompletion(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
        
        todo.setCompleted(!todo.isCompleted());
        Todo updatedTodo = todoRepository.save(todo);
        return new TodoResponse(updatedTodo);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException("Todo not found with id: " + id);
        }
        todoRepository.deleteById(id);
    }

    public List<TodoResponse> getTodosByStatus(boolean completed) {
        return todoRepository.findByCompletedOrderByCreatedAtDesc(completed)
                .stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }

    public long getTodoCount() {
        return todoRepository.count();
    }

    public long getCompletedTodoCount() {
        return todoRepository.countByCompleted(true);
    }

    public long getPendingTodoCount() {
        return todoRepository.countByCompleted(false);
    }
}