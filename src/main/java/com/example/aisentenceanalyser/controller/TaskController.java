package com.example.aisentenceanalyser.controller;

import com.example.aisentenceanalyser.dto.TaskRequest;
import com.example.aisentenceanalyser.dto.TaskResponse;
import com.example.aisentenceanalyser.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public TaskResponse getResponse(@RequestBody TaskRequest request) {
        return taskService.proceed(request);
    }
}
