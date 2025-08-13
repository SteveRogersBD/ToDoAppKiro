package com.example.todobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequest {
    
    @NotBlank(message = "Todo text cannot be empty")
    @Size(max = 255, message = "Todo text cannot exceed 255 characters")
    private String text;

    public TodoRequest() {}

    public TodoRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}