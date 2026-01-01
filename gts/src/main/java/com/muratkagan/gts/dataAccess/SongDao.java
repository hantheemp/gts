package com.muratkagan.gts.dataAccess;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Song;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SongDao implements ISongDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Song> getAll() {
		return entityManager.createQuery("SELECT s FROM Song s", Song.class).getResultList();
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
