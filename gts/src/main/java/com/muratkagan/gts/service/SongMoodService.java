package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dao.SongMoodDao;
import com.muratkagan.gts.entities.SongMood;

public class SongMoodService implements ISongMoodService {

	private SongMoodDao songMoodDao;

	@Override
	public List<SongMood> getAll() {
		return songMoodDao.getAll();
	}

	@Override
	public Optional<SongMood> getById(Integer id) {
		return songMoodDao.getById(id);
	}

	@Override
	public boolean insert(SongMood songMood) {
		return songMoodDao.insert(songMood);
	}

	@Override
	public boolean update(SongMood songMood) {
		return songMoodDao.update(songMood);
	}

	@Override
	public boolean delete(Integer id) {
		return songMoodDao.delete(id);
	}

}
