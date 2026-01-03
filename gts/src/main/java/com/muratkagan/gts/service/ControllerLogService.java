package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.ControllerLogDao;
import com.muratkagan.gts.entities.ControllerLog;

@Service
public class ControllerLogService implements IControllerLogService {

	private final ControllerLogDao controllerLogDao;

	@Autowired
	public ControllerLogService(ControllerLogDao controllerLogDao) {
		this.controllerLogDao = controllerLogDao;
	}

	@Override
	public List<ControllerLog> getAll() {
		return controllerLogDao.getAll();
	}

	@Override
	public Optional<ControllerLog> getById(Long id) {
		return controllerLogDao.getById(id);
	}

	@Override
	public Optional<ControllerLog> getByEndpoint(String endpoint) {
		return controllerLogDao.getByEndpoint(endpoint);
	}

	@Override
	public boolean insert(ControllerLog controllerLog) {
		return controllerLogDao.insert(controllerLog);
	}

	@Override
	public boolean update(ControllerLog controllerLog) {
		return controllerLogDao.update(controllerLog);
	}

	@Override
	public boolean delete(Long id) {
		return controllerLogDao.delete(id);
	}

}
