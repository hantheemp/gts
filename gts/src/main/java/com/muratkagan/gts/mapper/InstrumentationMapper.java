package com.muratkagan.gts.mapper;

import org.mapstruct.*;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.entities.Instrumentation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InstrumentationMapper {

	InstrumentationResponseDto toResponse(Instrumentation instrumentation);

	InstrumentationListItemDto toListItem(Instrumentation instrumentation);

	Instrumentation toEntity(InstrumentationCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(InstrumentationUpdateDto dto, @MappingTarget Instrumentation instrumentation);
}