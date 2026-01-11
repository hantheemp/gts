package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.SongCreateDto;
import com.muratkagan.gts.dto.SongListItemDto;
import com.muratkagan.gts.dto.SongResponseDto;
import com.muratkagan.gts.dto.SongUpdateDto;

public interface ISongService {

	List<SongListItemDto> getAll();

	Optional<SongResponseDto> getById(Integer id);

	SongResponseDto insert(SongCreateDto dto);

	SongResponseDto update(SongUpdateDto dto, Integer id);

	void delete(Integer id);

}
