package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.SongInstrumentationDao;
import com.muratkagan.gts.entities.SongInstrumentation;

@Service
public class SongInstrumentationService implements ISongInstrumentationService {

	private final SongInstrumentationDao songInstrumentationDao;

	@Autowired
	public SongInstrumentationService(SongInstrumentationDao songInstrumentationDao) {
		this.songInstrumentationDao = songInstrumentationDao;
	}

	@Override
	public List<SongInstrumentation> getAll() {
		return songInstrumentationDao.getAll();
	}

	@Override
	public Optional<SongInstrumentation> getById(Integer id) {
		return songInstrumentationDao.getById(id);
	}

	@Override
	public boolean insert(SongInstrumentation songInstrumentation) {
		return songInstrumentationDao.insert(songInstrumentation);
	}

	@Override
	public boolean update(SongInstrumentation songInstrumentation) {
		return songInstrumentationDao.update(songInstrumentation);
	}

	@Override
	public boolean delete(Integer id) {
		return songInstrumentationDao.delete(id);
	}

}
