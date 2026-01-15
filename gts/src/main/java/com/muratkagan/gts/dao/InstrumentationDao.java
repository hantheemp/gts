package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.Instrumentation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class InstrumentationDao implements IInstrumentationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Instrumentation> getAll() {

		return entityManager.createQuery("SELECT i FROM Instrumentation i", Instrumentation.class).getResultList();

	}

	@Override
	public Optional<Instrumentation> getById(Integer id) {

		Instrumentation instrumentation = entityManager.find(Instrumentation.class, id);
		return Optional.ofNullable(instrumentation);

	}

	@Override
	public List<Instrumentation> getByIds(Collection<Integer> ids) {
		if (ids == null || ids.isEmpty()) {
			return List.of();
		}
		return entityManager.createQuery("SELECT i FROM Instrumentation i WHERE i.id IN :ids", Instrumentation.class)
				.setParameter("ids", ids).getResultList();

	}

	@Override
	public Instrumentation insert(Instrumentation instrumentation) {

		entityManager.persist(instrumentation);
		return instrumentation;

	}

	@Override
	public Instrumentation update(Instrumentation instrumentation) {

		entityManager.merge(instrumentation);
		return instrumentation;

	}

	@Override
	public boolean delete(Integer id) {

		Instrumentation instrumentation = entityManager.find(Instrumentation.class, id);

		if (instrumentation == null) {
			return false;
		}

		else {
			entityManager.remove(instrumentation);
			return true;
		}

	}

}
