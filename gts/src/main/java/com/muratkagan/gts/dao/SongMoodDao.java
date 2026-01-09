package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import com.muratkagan.gts.entities.SongMood;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class SongMoodDao implements ISongMood {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<SongMood> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT sm FROM SongMood sm", SongMood.class).getResultList();
	}

	@Override
	public Optional<SongMood> getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable(session.find(SongMood.class, id));

	}

	@Override
	public boolean insert(SongMood songMood) {

		Session session = entityManager.unwrap(Session.class);

		session.persist(songMood);

		return true;

	}

	@Override
	public boolean update(SongMood songMood) {
		Session session = entityManager.unwrap(Session.class);

		SongMood persistedSongMood = session.find(SongMood.class, songMood.getSongId());
		boolean doesSongMoodExists = (persistedSongMood != null) ? true : false;

		if (!doesSongMoodExists) {
			return false;
		} else {

			persistedSongMood.setSongId(songMood.getSongId());
			persistedSongMood.setMoodId(songMood.getMoodId());

			session.merge(persistedSongMood);
			return true;
		}
	}

	@Override
	public boolean delete(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		SongMood persistedSongMood = session.find(SongMood.class, id);
		boolean doesSongMoodExists = (persistedSongMood != null) ? true : false;

		if (!doesSongMoodExists) {
			return false;
		} else {
			session.remove(doesSongMoodExists);
			return true;
		}
	}

}
