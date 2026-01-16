package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Mood;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MoodDao implements IMoodDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Mood> getAll() {
		return entityManager.createQuery("SELECT m FROM Mood m", Mood.class).getResultList();
	}

	@Override
	public Optional<Mood> getById(Integer id) {
		Mood mood = entityManager.find(Mood.class, id);
		return Optional.ofNullable(mood);
	}

	@Override
	public List<Mood> getByIds(Collection<Integer> ids) {
		if (ids == null || ids.isEmpty()){
			return List.of();
		}
		return entityManager.createQuery("SELECT m FROM Mood m WHERE m.id IN ids", Mood.class).setParameter("ids", ids).getResultList();
	}

	@Override
	public Mood insert(Mood mood) {

		entityManager.persist(mood);
		return mood;
	}

	@Override
	public Mood update(Mood mood) {

		entityManager.merge(mood);
		return mood;

	}

	@Override
	public boolean delete(Integer id) {

		Mood mood = entityManager.find(Mood.class, id);
		if (mood == null){
			return false;
		}
		else {
			entityManager.remove(mood);
			return true;
		}

	}
}
