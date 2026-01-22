package com.muratkagan.gts.audit.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.muratkagan.gts.audit.dto.AuditEventLogCreateDto;
import com.muratkagan.gts.audit.kafka.AuditEvent;
import com.muratkagan.gts.audit.service.AuditEventLogService;

@Component
public class AuditEventConsumer {

	private final AuditEventLogService auditEventLogService;

	public AuditEventConsumer(AuditEventLogService auditEventLogService) {
		this.auditEventLogService = auditEventLogService;
	}

	@KafkaListener(topics = "audit-events", groupId = "gts-audit-consumer")
	public void consume(AuditEvent event) {

		AuditEventLogCreateDto dto = new AuditEventLogCreateDto(event.getActorId(), event.getTargetId(),
				event.getEventType(), event.getTargetType(), event.getMetadata(), event.getOccurredAt(),
				event.getTraceId());

		auditEventLogService.insert(dto);
	}
}
