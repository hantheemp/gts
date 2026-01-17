package com.muratkagan.gts.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.ControllerLog;

public interface IControllerLogDao {

	List<ControllerLog> getAll();

	Optional<ControllerLog> getById(Integer id);

	List<ControllerLog> getByIds(Collection<Integer> ids);

	ControllerLog insert(ControllerLog controllerLog);

	ControllerLog update(ControllerLog controllerLog);

	boolean delete(Integer id);

}
