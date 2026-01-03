package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	public ArtistDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Artist> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<Artist> getById(int id) {

		Session session = entityManager.unwrap(Session.class);

		Artist artist = session.find(Artist.class, id);

		return Optional.ofNullable(artist);

	}
	
	@Override
	@Transactional
	public boolean insert(Artist artist) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.persist(artist);
		return true;
		
	}

	@Override
	@Transactional
	public boolean update(Artist artist) {

		Session session = entityManager.unwrap(Session.class);

		Artist persistedArtist = session.find(Artist.class, artist.getId());
		boolean doesArtistExists = (persistedArtist != null) ? true : false;

		if (!doesArtistExists) {
			return false;
		} else {
			persistedArtist.setName(artist.getName());
			persistedArtist.setSurname(artist.getSurname());
			persistedArtist.setCountryId(artist.getCountryId());
			persistedArtist.setCityId(artist.getCityId());
			persistedArtist.setBio(artist.getBio());
			persistedArtist.setSocialLinks(artist.getSocialLinks());

			session.merge(persistedArtist);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(int id) {

		Session session = entityManager.unwrap(Session.class);

		Artist persistedArtist = session.find(Artist.class, id);
		boolean doesArtistExists = (persistedArtist != null) ? true : false;

		if (!doesArtistExists) {
			return false;
		} else {
			session.remove(persistedArtist);
			return true;
		}

	}

}
