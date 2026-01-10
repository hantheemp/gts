package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.SongTempo;

public interface ISongTempoService {

	List<SongTempo> getAll();

	Optional<SongTempo> getById(Integer id);

	boolean insert(SongTempo songTempo);

	boolean update(SongTempo songTempo);

	boolean delete(Integer id);

}
