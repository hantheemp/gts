package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.entities.ControllerLog;

public interface IControllerLogService {
	
	List<ControllerLog> getAll();

    Optional<ControllerLog> getById(Long id);
    
    Optional<ControllerLog> getByEndpoint(String endpoint);
    
    boolean insert(ControllerLog controllerLog);
    
    boolean update(ControllerLog controllerLog);
	
    boolean delete(Long id);

}
