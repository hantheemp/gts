package com.muratkagan.gts.mapper;

import org.mapstruct.*;

import com.muratkagan.gts.entities.ControllerLog;
import com.muratkagan.gts.dto.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ControllerLogMapper {

	ControllerLogResponseDto toResponse(ControllerLog controllerLog);

	ControllerLogListItemDto toListItem(ControllerLog controllerLog);

	ControllerLog toEntity(ControllerLogCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(ControllerLogUpdateDto dto, @MappingTarget ControllerLog controllerLog);
}