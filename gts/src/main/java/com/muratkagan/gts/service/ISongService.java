package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Song;

public interface ISongService {

	List<Song> getAll();

    Optional<Song> getById(Integer id);
    
    boolean insert(Song song);

    boolean update(Song song);

    boolean delete(Integer id);
	
}
