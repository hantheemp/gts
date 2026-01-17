package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.*;

public interface IControllerLogService {

	List<ControllerLogListItemDto> getAll();

	Optional<ControllerLogResponseDto> getById(Integer id);

	ControllerLogResponseDto insert(ControllerLogCreateDto dto);

	ControllerLogResponseDto update(ControllerLogUpdateDto dto, Integer id);

	void delete(Integer id);

}
