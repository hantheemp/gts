package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Genre;

public interface IGenreDao {

	List<Genre> getAll();

	Optional<Genre> getById(Integer id);

	List<Genre> getByIds(Collection<Integer> ids);

	Genre insert(Genre genre);

	Genre update(Genre genre);

	boolean delete(Integer id);

}
