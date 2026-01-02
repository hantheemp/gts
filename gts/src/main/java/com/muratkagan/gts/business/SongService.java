package com.muratkagan.gts.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muratkagan.gts.dataAccess.SongDao;
import com.muratkagan.gts.entities.Song;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class SongService implements ISongService{
	
	public SongService(SongDao songDao) {
		this.songDao = songDao;
	}
	
	private final SongDao songDao;

	@Override
	public List<Song> getAll() {
		return songDao.getAll();
	}

	@Override
	public Optional<Song> getById(int id) {
		return songDao.getById(id);
	}

	@Override
	public boolean update(Song song) {
		return songDao.update(song);
	}

	@Override
	public boolean delete(int id) {
		return songDao.delete(id);
	}

}
