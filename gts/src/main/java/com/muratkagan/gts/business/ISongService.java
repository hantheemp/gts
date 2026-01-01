package com.muratkagan.gts.business;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entites.Song;

public interface ISongService {

	List<Song> getAll();

    Optional<Song> getById(int id);

    boolean update(Song song, int id);

    boolean delete(int id);
	
}
