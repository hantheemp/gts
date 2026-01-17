package com.muratkagan.gts.dto;

import java.util.Map;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ControllerLogCreateDto {

	@NotBlank
	@Size(max = 255)
	private String endpoint;

	@NotBlank
	@Size(max = 10)
	private String httpMethod;

	private Map<String, Object> requestPayload;
	private Map<String, Object> responsePayload;

	@NotNull
	private Integer statusCode;

	@Size(max = 50)
	private String clientIp;

	// Getters and setters

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

}