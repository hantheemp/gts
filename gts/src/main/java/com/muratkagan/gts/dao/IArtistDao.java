package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Artist;

public interface IArtistDao {

	List<Artist> getAll();

	Optional<Artist> getById(Integer id);

	List<Artist> getByIds(Collection<Integer> ids);

	Artist insert(Artist artist);

	Artist update(Artist artist);

	boolean delete(Integer id);

}
