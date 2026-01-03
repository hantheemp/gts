package com.muratkagan.gts.dao;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.ControllerLog;

public interface IControllerLogDao {

	List<ControllerLog> getAll();

    Optional<ControllerLog> getById(Long id);
    
    Optional<ControllerLog> getByEndpoint(String endpoint);
    
    boolean insert(ControllerLog controllerLog);
    
    boolean update(ControllerLog controllerLog);
	
    boolean delete(Long id);
    
}
