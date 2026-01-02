package com.muratkagan.gts.dataAccess;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Artist;

public interface IArtistDao {
	
	List<Artist> getAll();
	
	Optional<Artist> getById(int id);
	
	boolean insert(Artist artist);
	
	boolean update(Artist artist);
	
	boolean delete(int id);

}
