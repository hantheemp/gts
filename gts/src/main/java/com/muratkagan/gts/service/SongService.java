package com.muratkagan.gts.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.ArtistDao;
import com.muratkagan.gts.dao.SongDao;
import com.muratkagan.gts.dto.SongCreateDto;
import com.muratkagan.gts.dto.SongListItemDto;
import com.muratkagan.gts.dto.SongResponseDto;
import com.muratkagan.gts.dto.SongUpdateDto;
import com.muratkagan.gts.entities.Artist;
import com.muratkagan.gts.entities.Song;
import com.muratkagan.gts.mapper.SongMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SongService implements ISongService {

	private final SongDao songDao;
	private final ArtistDao artistDao;
	private final SongMapper songMapper;

	@Autowired
	public SongService(SongDao songDao, ArtistDao artistDao, SongMapper songMapper) {
		this.songDao = songDao;
		this.artistDao = artistDao;
		this.songMapper = songMapper;
	}

	/*
	 * SELF-NOTE: commented Artist fields (name, surname) enrichment since not sure
	 * about what fields will be useful.
	 */

	@Override
	public List<SongListItemDto> getAll() {
		List<Song> songs = songDao.getAll();

		/*
		 * Set<Integer> artistIds =
		 * songs.stream().map(Song::getArtistId).filter(Objects::nonNull)
		 * .collect(Collectors.toSet());
		 */

		/*
		 * Map<Integer, Artist> artistMap = artistDao.getByIds(artistIds).stream()
		 * .collect(Collectors.toMap(Artist::getId, a -> a));
		 */

		return songs.stream().map(s -> {
			SongListItemDto dto = new SongListItemDto();
			dto.setId(s.getId());
			dto.setTitle(s.getTitle());
			dto.setDurationSeconds(s.getDurationSeconds());
			dto.setArtistId(s.getArtistId());

			/*
			 * Artist artist = artistMap.get(s.getArtistId()); if (artist != null) {
			 * dto.setArtistName(artist.getName());
			 * dto.setArtistSurname(artist.getSurname()); }
			 */
			return dto;
		}).collect(Collectors.toList());

	}

	@Override
	public Optional<SongResponseDto> getById(Integer id) {
		return songDao.getById(id).map(songMapper::toResponse);
	}

	@Override
	public SongResponseDto insert(SongCreateDto dto) {
		// validate artist exists
		Artist artist = artistDao.getById(dto.getArtistId())
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));

		Song song = songMapper.toEntity(dto);
		song.setArtistId(artist.getId());

		Song persisted = songDao.insert(song);
		return songMapper.toResponse(persisted);
	}

	@Override
	public SongResponseDto update(SongUpdateDto dto, Integer id) {
		Song existing = songDao.getById(id).orElseThrow(() -> new IllegalArgumentException("Song not found"));

		// validate artist exists
		Artist artist = artistDao.getById(dto.getArtistId())
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));

		songMapper.updateFromDto(dto, existing);
		existing.setArtistId(artist.getId());

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
