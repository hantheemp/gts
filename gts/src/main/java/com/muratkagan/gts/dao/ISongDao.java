package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.Song;

public interface ISongDao {

    List<Song> getAll();

    Optional<Song> getById(int id);
    
    boolean insert(Song song);

    boolean update(Song song);

    boolean delete(int id);
}