package com.muratkagan.gts.audit.mapper;

import org.mapstruct.*;
import com.muratkagan.gts.audit.dto.AuditEventLogCreateDto;
import com.muratkagan.gts.audit.dto.AuditEventLogListItemDto;
import com.muratkagan.gts.audit.dto.AuditEventLogResponseDto;
import com.muratkagan.gts.audit.entity.AuditEventLog;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuditEventLogMapper {

	AuditEventLogResponseDto toResponse(AuditEventLog auditEventLog);

	AuditEventLogListItemDto toListItem(AuditEventLog auditEventLog);

	AuditEventLog toEntity(AuditEventLogCreateDto dto);
}