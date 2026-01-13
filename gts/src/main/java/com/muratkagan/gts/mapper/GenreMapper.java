package com.muratkagan.gts.mapper;

import org.mapstruct.*;
import com.muratkagan.gts.entities.Genre;
import com.muratkagan.gts.dto.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreMapper {

	GenreResponseDto toResponse(Genre genre);

	GenreListItemDto toListItem(Genre genre);

	Genre toEntity(GenreCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(GenreUpdateDto dto, @MappingTarget Genre genre);
}