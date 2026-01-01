package com.muratkagan.gts.dataAccess;

import java.util.List;
import java.util.Optional;
import com.muratkagan.gts.entites.Song;

public interface ISongDao {

    List<Song> getAll();

    Optional<Song> getById(int id);

    boolean update(Song song, int id);

    boolean delete(int id);
}