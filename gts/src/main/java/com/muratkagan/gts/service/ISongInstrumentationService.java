package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.SongInstrumentation;

public interface ISongInstrumentationService {

	List<SongInstrumentation> getAll();

	Optional<SongInstrumentation> getById(Integer id);

	boolean insert(SongInstrumentation songInstrumentation);

	boolean update(SongInstrumentation songInstrumentation);

	boolean delete(Integer id);

}
