package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Genre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class GenreDao implements IGenreDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Genre> getAll() {
		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
	}

	@Override
	@Transactional
	public Optional<Genre> getById(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable(session.find(Genre.class, id));
	}

	@Override
	@Transactional
	public boolean insert(Genre genre) {
		Session session = entityManager.unwrap(Session.class);

		session.persist(genre);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Genre genre) {
		Session session = entityManager.unwrap(Session.class);

		Genre persistedGenre = session.find(Genre.class, genre.getId());
		boolean doesGenreExists = (persistedGenre != null) ? true : false;

		if (!doesGenreExists) {
			return false;
		} else {
			persistedGenre.setName(genre.getName());

			session.merge(persistedGenre);
			return true;
		}
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		Genre persistedGenre = session.find(Genre.class, id);
		boolean doesGenreExists = (persistedGenre != null) ? true : false;

		if (!doesGenreExists) {
			return false;
		} else {
			session.remove(persistedGenre);
			return true;
		}

	}

}
