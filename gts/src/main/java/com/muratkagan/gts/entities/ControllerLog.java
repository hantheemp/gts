package com.muratkagan.gts.entities;

import java.time.OffsetDateTime;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "controller_logs")
public class ControllerLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String endpoint;
	private String httpMethod;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "request_payload", columnDefinition = "jsonb")
	private Map<String, Object> requestPayload;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "response_payload", columnDefinition = "jsonb")
	private Map<String, Object> responsePayload;

	@Column(name = "status_code")
	private Integer statusCode;

	@Column(name = "client_ip")
	private String clientIp;

	@CreationTimestamp
	@Column(updatable = false)
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