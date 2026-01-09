package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.SongGenreDao;
import com.muratkagan.gts.entities.SongGenre;

@Service
public class SongGenreService implements ISongGenreService {

	private final SongGenreDao songGenreDao;

	@Autowired
	public SongGenreService(SongGenreDao songGenreDao) {
		this.songGenreDao = songGenreDao;
	}

	@Override
	public List<SongGenre> getAll() {
		return songGenreDao.getAll();
	}

	@Override
	public Optional<SongGenre> getById(Integer id) {
		return songGenreDao.getById(id);
	}

	@Override
	public boolean insert(SongGenre songGenre) {
		return songGenreDao.insert(songGenre);
	}

	@Override
	public boolean update(SongGenre songGenre) {
		return songGenreDao.update(songGenre);
	}

	@Override
	public boolean delete(Integer id) {
		return songGenreDao.delete(id);
	}

}
