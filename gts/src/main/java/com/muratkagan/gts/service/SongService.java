package com.muratkagan.gts.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.ArtistDao;
import com.muratkagan.gts.dao.GenreDao;
import com.muratkagan.gts.dao.InstrumentationDao;
import com.muratkagan.gts.dao.SongDao;
import com.muratkagan.gts.dto.SongCreateDto;
import com.muratkagan.gts.dto.SongListItemDto;
import com.muratkagan.gts.dto.SongResponseDto;
import com.muratkagan.gts.dto.SongUpdateDto;
import com.muratkagan.gts.entities.Artist;
import com.muratkagan.gts.entities.Genre;
import com.muratkagan.gts.entities.Instrumentation;
import com.muratkagan.gts.entities.Song;
import com.muratkagan.gts.mapper.SongMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SongService implements ISongService {

	private final SongDao songDao;
	private final ArtistDao artistDao;
	private final GenreDao genreDao;
	private final InstrumentationDao instrumentationDao;
	private final SongMapper songMapper;

	@Autowired
	public SongService(SongDao songDao, ArtistDao artistDao, GenreDao genreDao, InstrumentationDao instrumentationDao,
			SongMapper songMapper) {
		this.songDao = songDao;
		this.artistDao = artistDao;
		this.genreDao = genreDao;
		this.instrumentationDao = instrumentationDao;
		this.songMapper = songMapper;
	}

	@Override
	public List<SongListItemDto> getAll() {
		List<Song> songs = songDao.getAll();

		return songs.stream().map(s -> {
			SongListItemDto dto = new SongListItemDto();
			dto.setId(s.getId());
			dto.setTitle(s.getTitle());
			dto.setDurationSeconds(s.getDurationSeconds());
			dto.setArtistId(s.getArtistId());
			return dto;
		}).collect(Collectors.toList());

	}

	@Override
	public Optional<SongResponseDto> getById(Integer id) {
		return songDao.getById(id).map(songMapper::toResponse);
	}

	@Override
	public SongResponseDto insert(SongCreateDto dto) {
		Artist artist = artistDao.getById(dto.getArtistId())
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));

		Song song = songMapper.toEntity(dto);
		song.setArtistId(artist.getId());

		if (dto.getGenreIds() != null && !dto.getGenreIds().isEmpty()) {
			List<Genre> genres = genreDao.getByIds(dto.getGenreIds());
			if (genres.size() != dto.getGenreIds().size()) {
				throw new IllegalArgumentException("One or more genres not found");
			}
			song.setGenres(new HashSet<>(genres));
		}
		
		if (dto.getInstrumentationIds() != null && !dto.getInstrumentationIds().isEmpty()) {
			List<Instrumentation> instrumentations = instrumentationDao.getByIds(dto.getInstrumentationIds());
			if (instrumentations.size() != dto.getInstrumentationIds().size()) {
				throw new IllegalArgumentException("One or more instrumentations not found");
			}
			song.setInstrumentations(new HashSet<>(instrumentations));
		}

		Song persisted = songDao.insert(song);
		return songMapper.toResponse(persisted);
	}

	@Override
	public SongResponseDto update(SongUpdateDto dto, Integer id) {
		Song existing = songDao.getById(id).orElseThrow(() -> new IllegalArgumentException("Song not found"));

		Artist artist = artistDao.getById(dto.getArtistId())
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));

		songMapper.updateFromDto(dto, existing);
		existing.setArtistId(artist.getId());

		if (dto.getGenreIds() != null) {
			List<Genre> genres = genreDao.getByIds(dto.getGenreIds());
			if (genres.size() != dto.getGenreIds().size()) {
				throw new IllegalArgumentException("One or more genres not found");
			}
			existing.setGenres(new HashSet<>(genres));
		}

		if (dto.getInstrumentationIds() != null) {
			List<Instrumentation> instrumentations = instrumentationDao.getByIds(dto.getInstrumentationIds());
			if (instrumentations.size() != dto.getInstrumentationIds().size()) {
				throw new IllegalArgumentException("One or more instrumentations not found");
			}
			existing.setInstrumentations(new HashSet<>(instrumentations));
		}

		Song updated = songDao.update(existing);

		return songMapper.toResponse(updated);

	}

	@Override
	public void delete(Integer id) {
		boolean removed = songDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("Song not found");

	}

}
