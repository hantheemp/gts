package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	public List<Genre> getAll() {

		return entityManager.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();

	}

	@Override
	public Optional<Genre> getById(Integer id) {

		Genre genre = entityManager.find(Genre.class, id);
		return Optional.ofNullable(genre);

	}

	@Override
	public List<Genre> getByIds(Collection<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre insert(Genre genre) {

		entityManager.persist(genre);
		return genre;

	}

	@Override
	public Genre update(Genre genre) {

		entityManager.merge(genre);
		return genre;

	}

	@Override
	public boolean delete(Integer id) {

		Genre genre = entityManager.find(Genre.class, id);
		if (genre == null) {
			return false;
		} else {
			entityManager.remove(genre);
			return true;
		}

	}

}
