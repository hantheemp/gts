package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.GenreDao;
import com.muratkagan.gts.entities.Genre;

@Service
public class GenreService implements IGenreService {

	private final GenreDao genreDao;

	@Autowired
	public GenreService(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	@Override
	public List<Genre> getAll() {
		return genreDao.getAll();
	}

	@Override
	public Optional<Genre> getById(Integer id) {
		return genreDao.getById(id);
	}

	@Override
	public boolean insert(Genre genre) {
		return genreDao.insert(genre);
	}

	@Override
	public boolean update(Genre genre) {
		return genreDao.update(genre);
	}

	@Override
	public boolean delete(Integer id) {
		return genreDao.delete(id);
	}

}
