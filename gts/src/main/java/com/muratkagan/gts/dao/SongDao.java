package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Song;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SongDao implements ISongDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public SongDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Song> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT s FROM Song s", Song.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<Song> getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		Song result = session.find(Song.class, id);
		return Optional.ofNullable(result);

	}
	
	@Override
	@Transactional
	public boolean insert(Song song) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.persist(song);
		return true;
		
	}

	@Override
	@Transactional
	public boolean update(Song song) {

		Session session = entityManager.unwrap(Session.class);
		Song persistedSong = session.find(Song.class, song.getId());
		boolean doesSongExists = (persistedSong != null) ? true : false;

		if (!doesSongExists) {
			return false;
		} else {

			persistedSong.setArtistId(song.getArtistId());
			persistedSong.setTitle(song.getTitle());
			persistedSong.setSubtitle(song.getSubtitle());
			persistedSong.setReleaseDate(song.getReleaseDate());
			persistedSong.setDurationSeconds(song.getDurationSeconds());
			persistedSong.setLanguage(song.getLanguage());

			session.merge(persistedSong);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		Song persistedSong = session.find(Song.class, id);
		boolean doesSongExists = (persistedSong != null) ? true : false;

		if (!doesSongExists) {
			return false;
		} else {
			session.remove(persistedSong);
			return true;
		}

	}

}
