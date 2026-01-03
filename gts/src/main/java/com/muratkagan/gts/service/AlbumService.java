package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.AlbumDao;
import com.muratkagan.gts.entities.Album;

@Service
public class AlbumService implements IAlbumService {

	private final AlbumDao albumDao;

	@Autowired
	public AlbumService(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	@Override
	public List<Album> getAll() {
		return albumDao.getAll();
	}

	@Override
	public Optional<Album> getById(Integer id) {
		return albumDao.getById(id);
	}

	@Override
	public boolean insert(Album album) {
		return albumDao.insert(album);
	}

	@Override
	public boolean update(Album album) {
		return albumDao.update(album);
	}

	@Override
	public boolean delete(Integer id) {
		return albumDao.delete(id);
	}

}
