package com.muratkagan.gts.audit.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.muratkagan.gts.audit.entity.AuditEventLog;
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

        AuditEventLog log = new AuditEventLog();
        log.setActorId(event.getActorId());
        log.setTargetId(event.getTargetId());
        log.setEventType(event.getEventType());
        log.setTargetType(event.getTargetType());
        log.setMetadata(event.getMetadata());
        log.setOccurredAt(event.getOccurredAt());
        log.setTraceId(event.getTraceId());

        auditEventLogService.insert(log);
    }
}

