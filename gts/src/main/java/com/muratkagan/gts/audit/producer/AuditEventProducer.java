package com.muratkagan.gts.audit.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.muratkagan.gts.audit.kafka.AuditEvent;

@Component
public class AuditEventProducer {

	private final KafkaTemplate<String, AuditEvent> kafkaTemplate;

	public AuditEventProducer(KafkaTemplate<String, AuditEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void publish(AuditEvent event) {
		kafkaTemplate.send("audit-events", event.getActorId().toString(), event);
	}

}
