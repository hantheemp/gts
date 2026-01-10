package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.SongTempo;

public interface ISongTempoDao {

	List<SongTempo> getAll();

	Optional<SongTempo> getById(Integer id);

	boolean insert(SongTempo songTempo);

	boolean update(SongTempo songTempo);

	boolean delete(Integer id);

}
