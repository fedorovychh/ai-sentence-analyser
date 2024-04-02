package com.example.aisentenceanalyser.mapper;

import com.example.aisentenceanalyser.config.MapperConfig;
import com.example.aisentenceanalyser.dto.TaskRequest;
import com.example.aisentenceanalyser.model.Task;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TaskMapper {
    Task toModel(TaskRequest request);
}
