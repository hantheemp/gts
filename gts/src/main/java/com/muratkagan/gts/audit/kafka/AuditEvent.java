package com.muratkagan.gts.audit.kafka;

import java.time.Instant;

public class AuditEvent {

    private Integer actorId;
    private Integer targetId;
    private String eventType;
    private String targetType;
    private String metadata;
    private Instant occurredAt;
    private String traceId;

    public AuditEvent() {
    }

    public AuditEvent(
            Integer actorId,
            Integer targetId,
            String eventType,
            String targetType,
            String metadata,
            Instant occurredAt,
            String traceId
    ) {
        this.actorId = actorId;
        this.targetId = targetId;
        this.eventType = eventType;
        this.targetType = targetType;
        this.metadata = metadata;
        this.occurredAt = occurredAt;
        this.traceId = traceId;
    }

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
