package com.muratkagan.gts.audit.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.audit.entity.AuditEventLog;

public interface IAuditEventLogDao {

	List<AuditEventLog> getAll();

	Optional<AuditEventLog> getById(Integer id);

	AuditEventLog insert(AuditEventLog album);

}
