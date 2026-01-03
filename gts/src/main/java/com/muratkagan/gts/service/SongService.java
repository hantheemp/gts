package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.SongDao;
import com.muratkagan.gts.entities.Song;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class SongService implements ISongService {

	@Autowired
	public SongService(SongDao songDao) {
		this.songDao = songDao;
	}

	private final SongDao songDao;

	@Override
	public List<Song> getAll() {
		return songDao.getAll();
	}

	@Override
	public Optional<Song> getById(Integer id) {
		return songDao.getById(id);
	}

	@Override
	public boolean insert(Song song) {
		return songDao.insert(song);
	}

	@Override
	public boolean update(Song song) {
		return songDao.update(song);
	}

	@Override
	public boolean delete(Integer id) {
		return songDao.delete(id);
	}

}
