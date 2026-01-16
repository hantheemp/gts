package com.muratkagan.gts.mapper;

import com.muratkagan.gts.entities.Mood;
import org.mapstruct.*;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.entities.Instrumentation;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MoodMapper {

    MoodResponseDto toResponse(Mood mood);

    MoodListItemDto toListItem(Mood mood);

    Mood toEntity(MoodCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(MoodUpdateDto dto, @MappingTarget Mood mood);
}