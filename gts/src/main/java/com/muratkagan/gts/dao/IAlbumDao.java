package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Album;

public interface IAlbumDao {

	List<Album> getAll();

	Optional<Album> getById(Integer id);

	List<Album> getByIds(Collection<Integer> ids);

	Album insert(Album album);

	Album update(Album album);

	boolean delete(Integer id);

}
