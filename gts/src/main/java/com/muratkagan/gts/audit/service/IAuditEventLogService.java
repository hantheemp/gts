package com.muratkagan.gts.audit.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.audit.dto.AuditEventLogCreateDto;
import com.muratkagan.gts.audit.dto.AuditEventLogListItemDto;
import com.muratkagan.gts.audit.dto.AuditEventLogResponseDto;

public interface IAuditEventLogService {

	List<AuditEventLogListItemDto> getAll();

	Optional<AuditEventLogResponseDto> getById(Integer id);

	AuditEventLogResponseDto insert(AuditEventLogCreateDto dto);

}
