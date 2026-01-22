package com.muratkagan.gts.audit.dto;

import java.time.Instant;

import jakarta.validation.constraints.*;

public class AuditEventLogCreateDto {

	@NotNull
	private final Integer actorId;

	@NotNull
	private final Integer targetId;

	@NotBlank
	@Size(max = 100)
	private final String eventType;

	@NotBlank
	@Size(max = 100)
	private final String targetType;

	@NotBlank
	private final String metadata;

	@NotNull
	@PastOrPresent
	private final Instant occurredAt;

	@NotBlank
	@Size(max = 100)
	private final String traceId;

	public AuditEventLogCreateDto(Integer actorId, Integer targetId, String eventType, String targetType,
			String metadata, Instant occurredAt, String traceId) {
		this.actorId = actorId;
		this.targetId = targetId;
		this.eventType = eventType;
		this.targetType = targetType;
		this.metadata = metadata;
		this.occurredAt = occurredAt;
		this.traceId = traceId;
	}
	
	// Getters and setters

	public Integer getActorId() {
		return actorId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public String getEventType() {
		return eventType;
	}

	public String getTargetType() {
		return targetType;
	}

	public String getMetadata() {
		return metadata;
	}

	public Instant getOccurredAt() {
		return occurredAt;
	}

	public String getTraceId() {
		return traceId;
	}
}
