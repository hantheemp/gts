package com.muratkagan.gts.audit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.audit.dao.AuditEventLogDao;
import com.muratkagan.gts.audit.entity.AuditEventLog;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuditEventLogService implements IAuditEventLogService {

	private final AuditEventLogDao auditEventLogDao;

	@Autowired
	public AuditEventLogService(AuditEventLogDao auditEventLogDao) {
		this.auditEventLogDao = auditEventLogDao;
	}

	@Override
	public List<AuditEventLog> getAll() {
		return auditEventLogDao.getAll().stream().collect(Collectors.toList());
	}

	@Override
	public Optional<AuditEventLog> getById(Integer id) {
		return auditEventLogDao.getById(id);
	}

	@Override
	public AuditEventLog insert(AuditEventLog auditEventLog) {

		AuditEventLog persisted = auditEventLogDao.insert(auditEventLog);
		return persisted;

	}

}
