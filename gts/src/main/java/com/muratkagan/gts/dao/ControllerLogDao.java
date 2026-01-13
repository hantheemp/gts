package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
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
	@Transactional
	public List<ControllerLog> getAll() {

		return entityManager.createQuery("SELECT c FROM ControllerLog c", ControllerLog.class).getResultList();

	}

	@Override
	@Transactional
	public Optional<ControllerLog> getById(Long id) {

		Session session = entityManager.unwrap(Session.class);

		ControllerLog controllerLog = session.find(ControllerLog.class, id);

		return Optional.ofNullable(controllerLog);

	}

	@Override
	@Transactional
	public Optional<ControllerLog> getByEndpoint(String endpoint) {

		Session session = entityManager.unwrap(Session.class);

		ControllerLog controllerLog = session.find(ControllerLog.class, endpoint);

		return Optional.ofNullable(controllerLog);

	}

	@Override
	@Transactional
	public boolean insert(ControllerLog controllerLog) {

		Session session = entityManager.unwrap(Session.class);

		session.persist(controllerLog);
		return true;

	}

	@Override
	@Transactional
	public boolean update(ControllerLog controllerLog) {

		Session session = entityManager.unwrap(Session.class);

		ControllerLog persistedControllerLog = session.find(ControllerLog.class, controllerLog.getId());
		boolean doesControllerLogExists = (persistedControllerLog != null) ? true : false;

		if (!doesControllerLogExists) {
			return false;
		} else {

			persistedControllerLog.setClientIp(controllerLog.getClientIp());
			persistedControllerLog.setEndpoint(controllerLog.getEndpoint());
			persistedControllerLog.setHttpMethod(controllerLog.getHttpMethod());
			persistedControllerLog.setId(controllerLog.getId());
			persistedControllerLog.setRequestPayload(controllerLog.getRequestPayload());
			persistedControllerLog.setResponsePayload(controllerLog.getResponsePayload());
			persistedControllerLog.setStatusCode(controllerLog.getStatusCode());

			session.merge(persistedControllerLog);
			return true;
		}

	}

	@Override
	@Transactional
	public boolean delete(Long id) {

		Session session = entityManager.unwrap(Session.class);

		ControllerLog persistedControllerLog = session.find(ControllerLog.class, id);
		boolean doesControllerLogExists = (persistedControllerLog != null) ? true : false;

		if (!doesControllerLogExists) {
			return false;
		} else {
			session.remove(persistedControllerLog);
			return true;
		}

	}

}
