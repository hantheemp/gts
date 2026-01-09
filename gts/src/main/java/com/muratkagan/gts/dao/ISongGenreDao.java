package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.SongGenre;

public interface ISongGenreDao {

	List<SongGenre> getAll();

	Optional<SongGenre> getById(Integer id);

	boolean insert(SongGenre songGenre);

	boolean update(SongGenre songGenre);

	boolean delete(Integer id);

}
