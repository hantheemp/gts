package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.SongInstrumentation;

public interface ISongInstrumentationDao {

	List<SongInstrumentation> getAll();

	Optional<SongInstrumentation> getById(Integer id);

	boolean insert(SongInstrumentation songInstrumentation);

	boolean update(SongInstrumentation songInstrumentation);

	boolean delete(Integer id);

}
