package com.example.aisentenceanalyser.dto;

import lombok.Data;

@Data
public class TaskResponse {
    private String response;

    public TaskResponse() {
    }

    public TaskResponse(String response) {
        this.response = response;
    }
}
