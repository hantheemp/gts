package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muratkagan.gts.entities.SongTempo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class SongTempoDao implements ISongTempoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<SongTempo> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT s FROM SongTempo s", SongTempo.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<SongTempo> getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable(session.find(SongTempo.class, id));

	}

	@Override
	@Transactional
	public boolean insert(SongTempo songTempo) {

		Session session = entityManager.unwrap(Session.class);

		session.persist(songTempo);
		return true;

	}

	@Override
	@Transactional
	public boolean update(SongTempo songTempo) {

		Session session = entityManager.unwrap(Session.class);

		SongTempo persistedSongTempo = session.find(SongTempo.class, songTempo.getSongId());
		boolean doesSongTempoExists = (persistedSongTempo != null) ? true : false;

		if (!doesSongTempoExists) {
			return false;
		} else {

			persistedSongTempo.setBpm(songTempo.getBpm());
			persistedSongTempo.setSongId(songTempo.getSongId());
			persistedSongTempo.setTempoBand(songTempo.getTempoBand());

			session.merge(persistedSongTempo);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		SongTempo persistedSongTempo = session.find(SongTempo.class, id);
		boolean doesSongTempoExists = (persistedSongTempo != null) ? true : false;

		if (!doesSongTempoExists) {
			return false;
		} else {
			session.remove(persistedSongTempo);
			return true;
		}

	}

}
