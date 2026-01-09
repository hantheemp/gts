package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muratkagan.gts.entities.SongGenre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class SongGenreDao implements ISongGenreDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<SongGenre> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT s FROM SongGenre s", SongGenre.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<SongGenre> getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable(session.find(SongGenre.class, id));

	}

	@Override
	@Transactional
	public boolean insert(SongGenre songGenre) {

		Session session = entityManager.unwrap(Session.class);

		session.persist(songGenre);
		return true;

	}

	@Override
	@Transactional
	public boolean update(SongGenre songGenre) {

		Session session = entityManager.unwrap(Session.class);
		SongGenre persistedSongGenre = session.find(SongGenre.class, songGenre.getSongId());
		boolean doesSongGenreExists = (persistedSongGenre != null) ? true : false;

		if (!doesSongGenreExists) {
			return false;
		} else {

			persistedSongGenre.setSongId(songGenre.getSongId());
			persistedSongGenre.setGenreId(songGenre.getGenreId());

			session.merge(persistedSongGenre);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		SongGenre persistedSongGenre = session.find(SongGenre.class, id);
		boolean doesSongGenreExists = (persistedSongGenre != null) ? true : false;

		if (!doesSongGenreExists) {
			return false;
		} else {
			session.remove(persistedSongGenre);
			return true;
		}

	}

}
