package com.muratkagan.gts.audit.entity;

import java.time.Instant;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.muratkagan.gts.audit.kafka.AuditEvent;

import jakarta.persistence.*;

@Entity
@Table(name = "audit_events")
public class AuditEventLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer actorId;

	@Column(nullable = false)
	private Integer targetId;

	@Column(nullable = false)
	private String eventType;

	@Column(nullable = false)
	private String targetType;

	@JdbcTypeCode(SqlTypes.JSON)
	private String metadata;

	@Column(nullable = false)
	private Instant occurredAt;

	private String traceId;

	public static AuditEventLog fromKafka(AuditEvent event) {
		AuditEventLog log = new AuditEventLog();

		log.actorId = event.getActorId();
		log.targetId = event.getTargetId();
		log.eventType = event.getEventType();
		log.targetType = event.getTargetType();
		log.metadata = event.getMetadata();
		log.occurredAt = event.getOccurredAt();
		log.traceId = event.getTraceId();

		return log;
	}

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
}
