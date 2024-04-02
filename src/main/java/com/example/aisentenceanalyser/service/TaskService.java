package com.example.aisentenceanalyser.service;

import com.example.aisentenceanalyser.dto.TaskRequest;
import com.example.aisentenceanalyser.dto.TaskResponse;

public interface TaskService {
    TaskResponse proceed(TaskRequest request);
}
