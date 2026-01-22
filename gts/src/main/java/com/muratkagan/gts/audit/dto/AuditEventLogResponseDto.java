package com.muratkagan.gts.audit.dto;

import java.time.Instant;
import java.time.OffsetDateTime;

public class AuditEventLogResponseDto {

	private Integer id;

	private Integer actorId;

	private Integer targetId;

	private String eventType;

	private String targetType;

	private String metadata;

	private Instant occurredAt;

	private String traceId;

	private OffsetDateTime createdAt;

	// Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public Instant getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(Instant occurredAt) {
		this.occurredAt = occurredAt;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
