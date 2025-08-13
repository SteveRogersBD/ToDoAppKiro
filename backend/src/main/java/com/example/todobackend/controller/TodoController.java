package com.example.todobackend.controller;

import com.example.todobackend.dto.TodoRequest;
import com.example.todobackend.dto.TodoResponse;
import com.example.todobackend.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllTodos() {
        List<TodoResponse> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id) {
        TodoResponse todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@Valid @RequestBody TodoRequest request) {
        TodoResponse todo = todoService.createTodo(request);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, 
                                                   @Valid @RequestBody TodoRequest request) {
        TodoResponse todo = todoService.updateTodo(id, request);
        return ResponseEntity.ok(todo);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<TodoResponse> toggleTodoCompletion(@PathVariable Long id) {
        TodoResponse todo = todoService.toggleTodoCompletion(id);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Todo deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{completed}")
    public ResponseEntity<List<TodoResponse>> getTodosByStatus(@PathVariable boolean completed) {
        List<TodoResponse> todos = todoService.getTodosByStatus(completed);
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getTodoStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("total", todoService.getTodoCount());
        stats.put("completed", todoService.getCompletedTodoCount());
        stats.put("pending", todoService.getPendingTodoCount());
        return ResponseEntity.ok(stats);
    }
}