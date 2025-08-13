package com.example.todoapp;

public class Todo {
    private String text;
    private boolean isCompleted;
    private long id;

    public Todo(String text) {
        this.text = text;
        this.isCompleted = false;
        this.id = System.currentTimeMillis();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}