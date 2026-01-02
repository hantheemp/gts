package com.muratkagan.gts.dataAccess;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Artist> getAll() {
		return entityManager.createQuery("SELECT a FROM Artist a ", Artist.class).getResultList();
	}

	@Override
	public Optional<Artist> getById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean update(Artist artist, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
