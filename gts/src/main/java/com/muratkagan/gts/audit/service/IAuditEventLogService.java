package com.muratkagan.gts.audit.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.audit.entity.AuditEventLog;

public interface IAuditEventLogService {

	List<AuditEventLog> getAll();

	Optional<AuditEventLog> getById(Integer id);

	AuditEventLog insert(AuditEventLog auditEventLog);

}
