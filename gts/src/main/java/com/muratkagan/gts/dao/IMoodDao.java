package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Mood;

public interface IMoodDao {

    List<Mood> getAll();

    Optional<Mood> getById(Integer id);

    List<Mood> getByIds(Collection<Integer> ids);

    Mood insert(Mood mood);

    Mood update(Mood mood);

    boolean delete(Integer id);

}
