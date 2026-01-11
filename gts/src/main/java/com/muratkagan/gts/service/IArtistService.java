package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.ArtistCreateDto;
import com.muratkagan.gts.dto.ArtistListItemDto;
import com.muratkagan.gts.dto.ArtistResponseDto;
import com.muratkagan.gts.dto.ArtistUpdateDto;

public interface IArtistService {

	List<ArtistListItemDto> getAll();

	Optional<ArtistResponseDto> getById(Integer id);

	ArtistResponseDto create(ArtistCreateDto dto);

	ArtistResponseDto update(Integer id, ArtistUpdateDto dto);

	void delete(Integer id);

}
