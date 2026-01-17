package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.muratkagan.gts.entities.ControllerLog;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ControllerLogDao implements IControllerLogDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ControllerLog> getAll() {

		return entityManager.createQuery("SELECT c FROM ControllerLog c", ControllerLog.class).getResultList();

	}

	@Override
	public Optional<ControllerLog> getById(Integer id) {

		ControllerLog controllerLog = entityManager.find(ControllerLog.class, id);
		return Optional.ofNullable(controllerLog);

	}

	@Override
	public List<ControllerLog> getByIds(Collection<Integer> ids) {

		if (ids == null || ids.isEmpty()) {
			return List.of();
		}

		return entityManager.createQuery("SELECT c FROM ControllerLog c WHERE c.id IN :ids", ControllerLog.class)
				.setParameter("ids", ids).getResultList();

	}

	@Override
	public ControllerLog insert(ControllerLog controllerLog) {

		entityManager.persist(controllerLog);
		return controllerLog;

	}

	@Override
	public ControllerLog update(ControllerLog controllerLog) {

		return entityManager.merge(controllerLog);

	}

	@Override
	public boolean delete(Integer id) {

		ControllerLog persisted = entityManager.find(ControllerLog.class, id);

		if (persisted == null) {
			return false;
		}
		entityManager.remove(persisted);
		return true;

	}

}
