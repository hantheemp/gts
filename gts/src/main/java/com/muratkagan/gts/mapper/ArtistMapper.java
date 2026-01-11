package com.muratkagan.gts.mapper;

import org.mapstruct.*;
import com.muratkagan.gts.entities.Artist;
import com.muratkagan.gts.dto.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArtistMapper {

	ArtistResponseDto toResponse(Artist artist);

	ArtistListItemDto toListItem(Artist artist);

	Artist toEntity(ArtistCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(ArtistUpdateDto dto, @MappingTarget Artist entity);
}