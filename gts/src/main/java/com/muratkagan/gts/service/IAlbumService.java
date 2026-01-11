package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.AlbumCreateDto;
import com.muratkagan.gts.dto.AlbumListItemDto;
import com.muratkagan.gts.dto.AlbumResponseDto;
import com.muratkagan.gts.dto.AlbumUpdateDto;

public interface IAlbumService {

	List<AlbumListItemDto> getAll();

	Optional<AlbumResponseDto> getById(Integer id);

	AlbumResponseDto insert(AlbumCreateDto dto);

	AlbumResponseDto update(AlbumUpdateDto dto, Integer id);

	void delete(Integer id);

}
