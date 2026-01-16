package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.GenreDao;
import com.muratkagan.gts.dto.GenreCreateDto;
import com.muratkagan.gts.dto.GenreListItemDto;
import com.muratkagan.gts.dto.GenreResponseDto;
import com.muratkagan.gts.dto.GenreUpdateDto;
import com.muratkagan.gts.entities.Genre;
import com.muratkagan.gts.mapper.GenreMapper;

@Service
public class GenreService implements IGenreService {

	private final GenreDao genreDao;
	private final GenreMapper mapper;

	@Autowired
	public GenreService(GenreDao genreDao, GenreMapper mapper) {
		this.genreDao = genreDao;
		this.mapper = mapper;
	}

	@Override
	public List<GenreListItemDto> getAll() {
		return genreDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());
	}

	@Override
	public Optional<GenreResponseDto> getById(Integer id) {
		return genreDao.getById(id).map(mapper::toResponse);
	}

	@Override
	public GenreResponseDto insert(GenreCreateDto dto) {

		Genre genre = mapper.toEntity(dto);

		Genre persisted = genreDao.insert(genre);
		return mapper.toResponse(persisted);

	}

	@Override
	public GenreResponseDto update(GenreUpdateDto dto, Integer id) {

		Genre existing = genreDao.getById(id).orElseThrow(() -> new IllegalArgumentException("Genre not found"));

		mapper.updateFromDto(dto, existing);

		Genre persisted = genreDao.update(existing);
		return mapper.toResponse(persisted);

	}

	@Override
	public void delete(Integer id) {

		boolean removed = genreDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("Genre not found");

	}

}
