package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Mood;

public interface IMoodService {

	List<Mood> getAll();

	Optional<Mood> getById(Integer id);

	boolean insert(Mood mood);

	boolean update(Mood mood);

	boolean delete(Integer id);

}
