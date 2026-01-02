package com.muratkagan.gts.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muratkagan.gts.dataAccess.ArtistDao;
import com.muratkagan.gts.entities.Artist;

@Service
public class ArtistService implements IArtistService {

	public ArtistService(ArtistDao artistDao) {
		this.artistDao = artistDao;
	}

	private final ArtistDao artistDao;

	@Override
	public List<Artist> getAll() {
		return artistDao.getAll();
	}

	@Override
	public Optional<Artist> getById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean update(Artist artist, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
