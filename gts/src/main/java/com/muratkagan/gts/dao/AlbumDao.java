package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
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
	@Transactional
	public List<Album> getAll() {
		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT a FROM Album a", Album.class).getResultList();
	}

	@Override
	@Transactional
	public Optional<Album> getById(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		return Optional.ofNullable(session.find(Album.class, id));
	}

	@Override
	@Transactional
	public boolean insert(Album album) {
		Session session = entityManager.unwrap(Session.class);

		session.persist(album);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Album album) {
		Session session = entityManager.unwrap(Session.class);

		Album persistedAlbum = session.find(Album.class, album.getId());
		boolean doesAlbumExists = (persistedAlbum != null) ? true : false;

		if (!doesAlbumExists) {
			return false;
		} else {
			persistedAlbum.setArtistId(album.getArtistId());
			persistedAlbum.setTitle(album.getTitle());
			persistedAlbum.setReleaseDate(album.getReleaseDate());
			persistedAlbum.setReleaseDate(album.getReleaseDate());

			session.merge(persistedAlbum);
			return true;
		}
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		Session session = entityManager.unwrap(Session.class);

		Album persistedAlbum = session.find(Album.class, id);
		boolean doesAlbumExists = (persistedAlbum != null) ? true : false;

		if (!doesAlbumExists) {
			return false;
		} else {
			session.remove(persistedAlbum);
			return true;
		}

	}

}
