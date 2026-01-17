package com.muratkagan.gts.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muratkagan.gts.dto.ControllerLogCreateDto;
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

	public DatabaseLogbookSink(ControllerLogService controllerLogService, ObjectMapper objectMapper) {
		this.controllerLogService = controllerLogService;
		this.objectMapper = objectMapper;
	}

	@Override
	public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
		ControllerLogCreateDto dto = new ControllerLogCreateDto();

		dto.setEndpoint(request.getPath());
		dto.setHttpMethod(request.getMethod());

		dto.setClientIp(request.getRemote());

		dto.setStatusCode(response.getStatus());

		String requestBody = request.getBodyAsString();
		dto.setRequestPayload(parseToMap(requestBody));

		String responseBody = response.getBodyAsString();
		dto.setResponsePayload(parseToMap(responseBody));

		controllerLogService.insert(dto);
	}

	private Map<String, Object> parseToMap(String body) {
		if (body == null || body.trim().isEmpty()) {
			return new HashMap<>();
		}

		try {
			return objectMapper.readValue(body, Map.class);
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<>();
			map.put("body", body);
			return map;
		}
	}

	@Override
	public void write(Precorrelation precorrelation, HttpRequest request) throws IOException {
	}
}