package com.muratkagan.gts.audit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.audit.dao.AuditEventLogDao;
import com.muratkagan.gts.audit.dto.AuditEventLogCreateDto;
import com.muratkagan.gts.audit.dto.AuditEventLogListItemDto;
import com.muratkagan.gts.audit.dto.AuditEventLogResponseDto;
import com.muratkagan.gts.audit.entity.AuditEventLog;
import com.muratkagan.gts.audit.mapper.AuditEventLogMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuditEventLogService implements IAuditEventLogService {

	private final AuditEventLogDao auditEventLogDao;
	private final AuditEventLogMapper mapper;

	@Autowired
	public AuditEventLogService(AuditEventLogDao auditEventLogDao, AuditEventLogMapper mapper) {
		this.auditEventLogDao = auditEventLogDao;
		this.mapper = mapper;
	}

	@Override
	public List<AuditEventLogListItemDto> getAll() {
		return auditEventLogDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());
	}

	@Override
	public Optional<AuditEventLogResponseDto> getById(Integer id) {
		return auditEventLogDao.getById(id).map(mapper::toResponse);
	}

	@Override
	public AuditEventLogResponseDto insert(AuditEventLogCreateDto dto) {
		AuditEventLog auditEventLog = mapper.toEntity(dto);
		auditEventLogDao.insert(auditEventLog);
		return mapper.toResponse(auditEventLog);
	}

}
