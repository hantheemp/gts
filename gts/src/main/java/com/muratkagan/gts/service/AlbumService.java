package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.AlbumDao;
import com.muratkagan.gts.dao.ArtistDao;
import com.muratkagan.gts.dto.AlbumCreateDto;
import com.muratkagan.gts.dto.AlbumListItemDto;
import com.muratkagan.gts.dto.AlbumResponseDto;
import com.muratkagan.gts.dto.AlbumUpdateDto;
import com.muratkagan.gts.entities.Album;
import com.muratkagan.gts.entities.Artist;
import com.muratkagan.gts.mapper.AlbumMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlbumService implements IAlbumService {

	private final AlbumDao albumDao;
	private final ArtistDao artistDao;
	private final AlbumMapper mapper;

	@Autowired
	public AlbumService(AlbumDao albumDao, ArtistDao artistDao, AlbumMapper mapper) {
		this.albumDao = albumDao;
		this.artistDao = artistDao;
		this.mapper = mapper;
	}

	@Override
	public List<AlbumListItemDto> getAll() {
		return albumDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());
	}

	@Override
	public Optional<AlbumResponseDto> getById(Integer id) {
		return albumDao.getById(id).map(mapper::toResponse);
	}

	@Override
	public AlbumResponseDto insert(AlbumCreateDto dto) {
		Artist artist = artistDao.getById(dto.getArtistId())
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));

		Album album = mapper.toEntity(dto);
		album.setArtistId(artist.getId());

		Album persisted = albumDao.insert(album);
		return mapper.toResponse(persisted);

	}

	@Override
	public AlbumResponseDto update(AlbumUpdateDto dto, Integer id) {

		Album existing = albumDao.getById(id).orElseThrow(() -> new IllegalArgumentException("Album not found"));

		Artist artist = artistDao.getById(dto.getArtistId())
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));

		mapper.updateFromDto(dto, existing);
		existing.setArtistId(artist.getId());

		Album persisted = albumDao.insert(existing);
		return mapper.toResponse(persisted);

	}

	@Override
	public void delete(Integer id) {

		boolean removed = albumDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("Album not found");

	}

}
