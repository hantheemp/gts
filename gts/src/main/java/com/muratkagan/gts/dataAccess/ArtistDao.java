package com.muratkagan.gts.dataAccess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

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
		return entityManager.createQuery("SELECT a FROM Artist a ", Artist.class).getResultList();
	}

	@Override
	@Transactional
	public Optional<Artist> getById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	@Transactional
	public boolean update(Artist artist, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
