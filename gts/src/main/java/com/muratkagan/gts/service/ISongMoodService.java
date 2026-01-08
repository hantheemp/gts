package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.SongMood;

public interface ISongMoodService {

	List<SongMood> getAll();

	Optional<SongMood> getById(Integer id);

	boolean insert(SongMood songMood);

	boolean update(SongMood songMood);

	boolean delete(Integer id);

}
