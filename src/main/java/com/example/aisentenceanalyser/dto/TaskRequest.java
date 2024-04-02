package com.example.aisentenceanalyser.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank
    private String inputTask;
    @NotBlank
    private String inputSentence;
}
