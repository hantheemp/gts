package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Album;

public interface IAlbumDao {

	List<Album> getAll();

	Optional<Album> getById(Integer id);

	boolean insert(Album album);

	boolean update(Album album);

	boolean delete(Integer id);

}
