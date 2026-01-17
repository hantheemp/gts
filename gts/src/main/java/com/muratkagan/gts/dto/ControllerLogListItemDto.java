package com.muratkagan.gts.dto;

import java.time.OffsetDateTime;
import java.util.Map;

public class ControllerLogListItemDto {

	private Long id;
	private String endpoint;
	private String httpMethod;
	private Map<String, Object> requestPayload;
	private Map<String, Object> responsePayload;
	private Integer statusCode;
	private String clientIp;
	private OffsetDateTime executedAt;

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public Map<String, Object> getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(Map<String, Object> requestPayload) {
		this.requestPayload = requestPayload;
	}

	public Map<String, Object> getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(Map<String, Object> responsePayload) {
		this.responsePayload = responsePayload;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public OffsetDateTime getExecutedAt() {
		return executedAt;
	}

	public void setExecutedAt(OffsetDateTime executedAt) {
		this.executedAt = executedAt;
	}

}