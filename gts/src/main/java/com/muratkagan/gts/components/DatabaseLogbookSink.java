package com.muratkagan.gts.components;

import tools.jackson.databind.ObjectMapper;
import com.muratkagan.gts.entities.ControllerLog;
import com.muratkagan.gts.service.ControllerLogService;

import org.springframework.stereotype.Component;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpRequest;
import org.zalando.logbook.HttpResponse;
import org.zalando.logbook.Precorrelation;
import org.zalando.logbook.Sink;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseLogbookSink implements Sink {

    private final ControllerLogService controllerLogService;
    private final ObjectMapper objectMapper;

    public DatabaseLogbookSink(ControllerLogService controllerLogRepository, ObjectMapper objectMapper) {
        this.controllerLogService = controllerLogRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
        ControllerLog log = new ControllerLog();
        
        // Set endpoint and HTTP method
        log.setEndpoint(request.getPath());
        log.setHttpMethod(request.getMethod());
        
        // Set client IP
        log.setClientIp(request.getRemote());
        
        // Set status code
        log.setStatusCode(response.getStatus());
        
        // Parse and set request payload
        String requestBody = request.getBodyAsString();
        log.setRequestPayload(parseToMap(requestBody));
        
        // Parse and set response payload
        String responseBody = response.getBodyAsString();
        log.setResponsePayload(parseToMap(responseBody));
        
        // Save to database
        controllerLogService.insert(log);
    }

    private Map<String, Object> parseToMap(String body) {
        if (body == null || body.trim().isEmpty()) {
            return new HashMap<>();
        }
        
        try {
            // Try to parse as JSON
            return objectMapper.readValue(body, Map.class);
        } catch (Exception e) {
            // If not valid JSON, store as plain text
            Map<String, Object> map = new HashMap<>();
            map.put("body", body);
            return map;
        }
    }

	@Override
	public void write(Precorrelation precorrelation, HttpRequest request) throws IOException {
		// TODO Auto-generated method stub
		
	}
}