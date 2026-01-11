package com.muratkagan.gts.mapper;

import org.mapstruct.*;

import com.muratkagan.gts.dto.SongCreateDto;
import com.muratkagan.gts.dto.SongListItemDto;
import com.muratkagan.gts.dto.SongResponseDto;
import com.muratkagan.gts.dto.SongUpdateDto;
import com.muratkagan.gts.entities.Song;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SongMapper {

	SongResponseDto toResponse(Song song);

	SongListItemDto toListItem(Song artist);

	Song toEntity(SongCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(SongUpdateDto dto, @MappingTarget Song entity);
}