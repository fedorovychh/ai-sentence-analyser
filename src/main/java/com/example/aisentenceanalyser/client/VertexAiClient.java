package com.example.aisentenceanalyser.client;

import com.example.aisentenceanalyser.model.Task;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class VertexAiClient {
    private static final int ZERO_INDEX = 0;
    private static final int JSON_START_INDEX = 8;
    private static final int JSON_END_INDEX = 4;
    private static final String PROJECT_ID = "189614622483";
    private static final String LOCATION_REGION = "us-central1";
    private static final String MODEL_NAME = "gemini-1.0-pro-vision";

    public String sendRequest(Task requiredTask) {
        GenerateContentResponse output = quickstart(
                requiredTask.getInputTask(),
                requiredTask.getInputSentence()
        );
        String text = output.getCandidates(ZERO_INDEX)
                .getContent()
                .getParts(ZERO_INDEX)
                .getText();
        return formatToJsonString(text);
    }

    private GenerateContentResponse quickstart(String requiredTask, String requiredSentence) {
        try (VertexAI vertexAI = new VertexAI(PROJECT_ID, LOCATION_REGION)) {
            GenerativeModel model = new GenerativeModel(MODEL_NAME, vertexAI);
            return model.generateContent(requiredTask + requiredSentence);
        } catch (IOException e) {
            throw new RuntimeException("Can't proceed the request!", e);
        }
    }

    private static String formatToJsonString(String responseText) {
        return responseText.substring(JSON_START_INDEX, responseText.length() - JSON_END_INDEX);
    }
}
