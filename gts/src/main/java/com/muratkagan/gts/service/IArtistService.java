package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Artist;

public interface IArtistService {
	
	List<Artist> getAll();
	
	Optional<Artist> getById(Integer id);
	
	boolean insert(Artist artist);
	
	boolean update(Artist artist);

	boolean delete(Integer id);
	
}
