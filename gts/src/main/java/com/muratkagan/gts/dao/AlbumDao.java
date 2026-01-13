package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Album;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlbumDao implements IAlbumDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Album> getAll() {

		return entityManager.createQuery("SELECT a FROM Album a", Album.class).getResultList();

	}

	@Override
	public Optional<Album> getById(Integer id) {

		Album album = entityManager.find(Album.class, id);
		return Optional.ofNullable(album);

	}

	public List<Album> getByIds(Collection<Integer> ids) {
		if (ids == null || ids.isEmpty()) {
			return List.of();
		}
		return entityManager.createQuery("SELECT a FROM Album a WHERE a.id IN :ids", Album.class)
				.setParameter("ids", ids).getResultList();
	}

	@Override
	public Album insert(Album album) {
		entityManager.persist(album);
		return album;
	}

	@Override
	public Album update(Album album) {
		entityManager.merge(album);
		return album;
	}

	@Override
	public boolean delete(Integer id) {

		Album album = entityManager.find(Album.class, id);

		if (album == null) {
			return false;
		} else {
			entityManager.remove(album);
			return true;
		}

	}

}
