package com.muratkagan.gts.mapper;

import org.mapstruct.*;
import com.muratkagan.gts.entities.Album;
import com.muratkagan.gts.dto.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AlbumMapper {

	AlbumResponseDto toResponse(Album album);

	AlbumListItemDto toListItem(Album album);

	Album toEntity(AlbumCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(AlbumUpdateDto dto, @MappingTarget Album entity);
}