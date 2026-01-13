package com.muratkagan.gts.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.*;

import com.muratkagan.gts.dto.SongCreateDto;
import com.muratkagan.gts.dto.SongListItemDto;
import com.muratkagan.gts.dto.SongResponseDto;
import com.muratkagan.gts.dto.SongUpdateDto;
import com.muratkagan.gts.entities.Genre;
import com.muratkagan.gts.entities.Song;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SongMapper {

	@Mappings(@Mapping(target = "genres", source = "genres"))
	SongResponseDto toResponse(Song song);

	SongListItemDto toListItem(Song song);

	Song toEntity(SongCreateDto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateFromDto(SongUpdateDto dto, @MappingTarget Song song);

	default List<String> mapGenres(Set<Genre> genres) {
		if (genres == null) {
			return null;
		}
		return genres.stream().map(Genre::getName).collect(Collectors.toList());
	}

}