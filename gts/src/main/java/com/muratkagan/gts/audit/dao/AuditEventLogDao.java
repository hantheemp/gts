package com.muratkagan.gts.audit.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.muratkagan.gts.audit.entity.AuditEventLog;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AuditEventLogDao implements IAuditEventLogDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<AuditEventLog> getAll() {

		return entityManager.createQuery("SELECT a FROM AuditEventLog a", AuditEventLog.class).getResultList();

	}

	@Override
	public Optional<AuditEventLog> getById(Integer id) {

		AuditEventLog auditEventLog = entityManager.find(AuditEventLog.class, id);
		return Optional.ofNullable(auditEventLog);

	}

	public List<AuditEventLog> getByIds(Collection<Integer> ids) {
		if (ids == null || ids.isEmpty()) {
			return List.of();
		}
		return entityManager.createQuery("SELECT a FROM AuditEventLog a WHERE a.id IN :ids", AuditEventLog.class)
				.setParameter("ids", ids).getResultList();
	}

	@Override
	public AuditEventLog insert(AuditEventLog auditEventLog) {
		entityManager.persist(auditEventLog);
		return auditEventLog;
	}

}
