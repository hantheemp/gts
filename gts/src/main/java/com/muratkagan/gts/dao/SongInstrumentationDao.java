package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muratkagan.gts.entities.SongInstrumentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class SongInstrumentationDao implements ISongInstrumentationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<SongInstrumentation> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT s FROM SongInstrumentation s", SongInstrumentation.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<SongInstrumentation> getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable(session.find(SongInstrumentation.class, id));

	}

	@Override
	@Transactional
	public boolean insert(SongInstrumentation songInstrumentation) {

		Session session = entityManager.unwrap(Session.class);

		session.persist(songInstrumentation);
		return true;

	}

	@Override
	@Transactional
	public boolean update(SongInstrumentation songInstrumentation) {

		Session session = entityManager.unwrap(Session.class);

		SongInstrumentation persistedSongInstrumentation = session.find(SongInstrumentation.class,
				songInstrumentation.getSongId());
		boolean doesSongInstrumentationExists = (persistedSongInstrumentation != null) ? true : false;

		if (!doesSongInstrumentationExists) {
			return false;
		} else {

			persistedSongInstrumentation.setInstrumentationId(songInstrumentation.getInstrumentationId());
			persistedSongInstrumentation.setSongId(songInstrumentation.getSongId());

			session.merge(persistedSongInstrumentation);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		SongInstrumentation persistedSongInstrumentation = session.find(SongInstrumentation.class, id);
		boolean doesSongInstrumentationExists = (persistedSongInstrumentation != null) ? true : false;

		if (!doesSongInstrumentationExists) {
			return false;
		} else {
			session.remove(persistedSongInstrumentation);
			return true;
		}

	}

}
