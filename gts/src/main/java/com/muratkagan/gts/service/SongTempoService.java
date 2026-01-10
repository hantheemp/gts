package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.SongTempoDao;
import com.muratkagan.gts.entities.SongTempo;

@Service
public class SongTempoService implements ISongTempoService {

	private final SongTempoDao songTempoDao;

	@Autowired
	public SongTempoService(SongTempoDao songTempoDao) {
		this.songTempoDao = songTempoDao;
	}

	@Override
	public List<SongTempo> getAll() {
		return songTempoDao.getAll();
	}

	@Override
	public Optional<SongTempo> getById(Integer id) {
		return songTempoDao.getById(id);
	}

	@Override
	public boolean insert(SongTempo songTempo) {
		return songTempoDao.insert(songTempo);
	}

	@Override
	public boolean update(SongTempo songTempo) {
		return songTempoDao.update(songTempo);
	}

	@Override
	public boolean delete(Integer id) {
		return songTempoDao.delete(id);
	}

}
