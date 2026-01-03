package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.ArtistDao;
import com.muratkagan.gts.entities.Artist;

@Service
public class ArtistService implements IArtistService {

	@Autowired
	public ArtistService(ArtistDao artistDao) {
		this.artistDao = artistDao;
	}

	private final ArtistDao artistDao;

	@Override
	public List<Artist> getAll() {
		return artistDao.getAll();
	}

	@Override
	public Optional<Artist> getById(Integer id) {
		return artistDao.getById(id);
	}
	
	@Override
	public boolean insert(Artist artist) {
		return artistDao.insert(artist);
	}

	@Override
	public boolean update(Artist artist) {
		return artistDao.update(artist);
	}

	@Override
	public boolean delete(Integer id) {
		return artistDao.delete(id);
	}

}
