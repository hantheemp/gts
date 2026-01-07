package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
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
	@Transactional
	public List<Mood> getAll() {

		Session session = entityManager.unwrap(Session.class);

		return session.createQuery("SELECT m FROM Mood m", Mood.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<Mood> getById(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		Mood result = session.find(Mood.class, id);
		return Optional.ofNullable(result);

	}

	@Override
	@Transactional
	public boolean insert(Mood mood) {

		Session session = entityManager.unwrap(Session.class);

		session.persist(mood);
		return true;

	}

	@Override
	@Transactional
	public boolean update(Mood mood) {

		Session session = entityManager.unwrap(Session.class);

		Mood persistedMood = session.find(Mood.class, mood.getId());
		boolean doesMoodExists = (persistedMood != null) ? true : false;

		if (!doesMoodExists) {
			return false;
		} else {

			persistedMood.setId(mood.getId());
			persistedMood.setName(mood.getName());

			session.merge(persistedMood);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(Integer id) {

		Session session = entityManager.unwrap(Session.class);

		Mood persistedMood = session.find(Mood.class, id);
		boolean doesMoodExists = (persistedMood != null) ? true : false;

		if (!doesMoodExists) {
			return false;
		} else {
			session.remove(doesMoodExists);
			return true;
		}

	}

}
