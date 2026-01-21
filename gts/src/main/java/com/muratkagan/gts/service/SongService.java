package com.muratkagan.gts.service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.muratkagan.gts.audit.kafka.AuditEvent;
import com.muratkagan.gts.audit.producer.AuditEventProducer;
import com.muratkagan.gts.dao.*;
import com.muratkagan.gts.entities.*;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dto.SongCreateDto;
import com.muratkagan.gts.dto.SongListItemDto;
import com.muratkagan.gts.dto.SongResponseDto;
import com.muratkagan.gts.dto.SongUpdateDto;
import com.muratkagan.gts.mapper.SongMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SongService implements ISongService {

	private final SongDao songDao;
	private final ArtistDao artistDao;
	private final GenreDao genreDao;
	private final InstrumentationDao instrumentationDao;
	private final MoodDao moodDao;
	private final AuditEventProducer auditEventProducer;
	private final SongMapper songMapper;

	@Autowired
	public SongService(SongDao songDao, ArtistDao artistDao, GenreDao genreDao, InstrumentationDao instrumentationDao,
			MoodDao moodDao, AuditEventProducer auditEventProducer, SongMapper songMapper) {
		this.songDao = songDao;
		this.artistDao = artistDao;
		this.genreDao = genreDao;
		this.instrumentationDao = instrumentationDao;
		this.moodDao = moodDao;
		this.auditEventProducer = auditEventProducer;
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

		if (dto.getMoodIds() != null && !dto.getMoodIds().isEmpty()) {
			List<Mood> moods = moodDao.getByIds(dto.getMoodIds());
			if (moods.size() != dto.getMoodIds().size()) {
				throw new IllegalArgumentException("One or more moods not found");
			}
			song.setMoods(new HashSet<>(moods));
		}

		Song persisted = songDao.insert(song);

		AuditEvent event = new AuditEvent(1, persisted.getId(), "SONG_CREATED", "SONG",
				"{\"title\":\"" + persisted.getTitle() + "\"}", Instant.now(), MDC.get("traceId"));

		auditEventProducer.publish(event);

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

		if (dto.getMoodIds() != null && !dto.getMoodIds().isEmpty()) {
			List<Mood> moods = moodDao.getByIds(dto.getMoodIds());
			if (moods.size() != dto.getMoodIds().size()) {
				throw new IllegalArgumentException("One or more moods not found");
			}
			existing.setMoods(new HashSet<>(moods));
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
