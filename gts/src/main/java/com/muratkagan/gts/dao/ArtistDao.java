package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArtistDao implements IArtistDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Artist> getAll() {

		return entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();

	}

	@Override
	public Optional<Artist> getById(Integer id) {

		Artist artist = entityManager.find(Artist.class, id);
		return Optional.ofNullable(artist);

	}

	public List<Artist> getByIds(Collection<Integer> ids) {
		if (ids == null || ids.isEmpty())
			return Collections.emptyList();
		return entityManager.unwrap(Session.class)
				.createQuery("SELECT a FROM Artist a WHERE a.id IN :ids", Artist.class).setParameter("ids", ids)
				.getResultList();
	}

	@Override
	public Artist insert(Artist artist) {

		entityManager.persist(artist);
		return artist;

	}

	@Override
	public Artist update(Artist artist) {

		return entityManager.merge(artist);

	}

	@Override
	public boolean delete(Integer id) {

		Artist persisted = entityManager.find(Artist.class, id);
		if (persisted == null)
			return false;
		entityManager.remove(persisted);
		return true;

	}

}
