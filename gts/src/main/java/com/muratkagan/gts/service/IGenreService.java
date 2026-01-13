package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.GenreCreateDto;
import com.muratkagan.gts.dto.GenreListItemDto;
import com.muratkagan.gts.dto.GenreResponseDto;
import com.muratkagan.gts.dto.GenreUpdateDto;
import com.muratkagan.gts.entities.Genre;

public interface IGenreService {

	List<GenreListItemDto> getAll();

	Optional<GenreResponseDto> getById(Integer id);

	GenreResponseDto insert(GenreCreateDto dto);

	GenreResponseDto update(GenreUpdateDto dto, Integer id);

	void delete(Integer id);

}
