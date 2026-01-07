package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.MoodDao;
import com.muratkagan.gts.entities.Mood;

@Service
public class MoodService implements IMoodService {

	@Autowired
	public MoodService(MoodDao moodDao) {
		this.moodDao = moodDao;
	}
	
	private MoodDao moodDao;

	@Override
	public List<Mood> getAll() {
		return moodDao.getAll();
	}

	@Override
	public Optional<Mood> getById(Integer id) {
		return moodDao.getById(id);
	}

	@Override
	public boolean insert(Mood mood) {
		return moodDao.insert(mood);
	}

	@Override
	public boolean update(Mood mood) {
		return moodDao.update(mood);
	}

	@Override
	public boolean delete(Integer id) {
		return moodDao.delete(id);
	}

}
