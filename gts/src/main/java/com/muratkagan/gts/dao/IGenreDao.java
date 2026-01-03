package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Genre;

public interface IGenreDao {
	
	List<Genre> getAll();

	Optional<Genre> getById(Integer id);

	boolean insert(Genre genre);

	boolean update(Genre genre);

	boolean delete(Integer id);

}
