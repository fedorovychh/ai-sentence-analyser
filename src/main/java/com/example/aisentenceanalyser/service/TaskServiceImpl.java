package com.example.aisentenceanalyser.service;

import com.example.aisentenceanalyser.client.VertexAiClient;
import com.example.aisentenceanalyser.dto.TaskRequest;
import com.example.aisentenceanalyser.dto.TaskResponse;
import com.example.aisentenceanalyser.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;
    private final VertexAiClient vertexAiClient;

    @Override
    public TaskResponse proceed(TaskRequest request) {
        String responseText = vertexAiClient.sendRequest(taskMapper.toModel(request));
        return new TaskResponse(responseText);
    }
}
