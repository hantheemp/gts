package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.muratkagan.gts.dao.IArtistDao;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.entities.Artist;
import com.muratkagan.gts.mapper.ArtistMapper;

@Service
@Transactional
public class ArtistService implements IArtistService {

	private final IArtistDao artistDao;
	private final ArtistMapper mapper;

	public ArtistService(IArtistDao artistDao, ArtistMapper mapper) {
		this.artistDao = artistDao;
		this.mapper = mapper;
	}

	@Override
	public List<ArtistListItemDto> getAll() {
		return artistDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());
	}

	@Override
	public Optional<ArtistResponseDto> getById(Integer id) {
		return artistDao.getById(id).map(mapper::toResponse);
	}

	@Override
	public ArtistResponseDto insert(ArtistCreateDto dto) {
		Artist entity = mapper.toEntity(dto);
		Artist persisted = artistDao.insert(entity);
		return mapper.toResponse(persisted);
	}

	@Override
	public ArtistResponseDto update(Integer id, ArtistUpdateDto dto) {
		Artist existing = artistDao.getById(id).orElseThrow(() -> new IllegalArgumentException("Artist not found"));
		mapper.updateFromDto(dto, existing);
		Artist updated = artistDao.update(existing);
		return mapper.toResponse(updated);
	}

	@Override
	public void delete(Integer id) {
		boolean removed = artistDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("Artist not found");
	}
}