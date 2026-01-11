package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
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

	@Override
	public List<Song> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT s FROM Song s", Song.class).getResultList();

	}

	@Override
	public Optional<Song> getById(Integer id) {

		Song song = entityManager.find(Song.class, id);
		return Optional.ofNullable(song);

	}

	public List<Song> getByIds(Collection<Integer> ids) {
		if (ids == null || ids.isEmpty())
			return Collections.emptyList();
		return entityManager.unwrap(Session.class).createQuery("SELECT s FROM Song s WHERE s.id IN :ids", Song.class)
				.setParameter("ids", ids).getResultList();
	}

	@Override
	public Song insert(Song song) {

		entityManager.persist(song);
		return song;

	}

	@Override
	public Song update(Song song) {

		entityManager.merge(song);
		return song;

	}

	@Override
	public boolean delete(Integer id) {

		Song song = entityManager.find(Song.class, id);
		if (song == null) {
			return false;
		} else {
			entityManager.remove(song);
			return true;
		}

	}

}
