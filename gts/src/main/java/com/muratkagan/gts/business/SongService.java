package com.muratkagan.gts.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muratkagan.gts.dataAccess.SongDao;
import com.muratkagan.gts.entites.Song;

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
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean update(Song song, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
