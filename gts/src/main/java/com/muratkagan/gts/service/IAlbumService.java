package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Album;

public interface IAlbumService {
	
	List<Album> getAll();
	
	Optional<Album> getById(Integer id);
	
	boolean insert(Album album);
	
	boolean update(Album album);

	boolean delete(Integer id);
	
}
