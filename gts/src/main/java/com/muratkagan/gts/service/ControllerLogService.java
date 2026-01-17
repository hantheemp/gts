package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.ControllerLogDao;
import com.muratkagan.gts.dto.ControllerLogCreateDto;
import com.muratkagan.gts.dto.ControllerLogListItemDto;
import com.muratkagan.gts.dto.ControllerLogResponseDto;
import com.muratkagan.gts.dto.ControllerLogUpdateDto;
import com.muratkagan.gts.entities.ControllerLog;
import com.muratkagan.gts.mapper.ControllerLogMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ControllerLogService implements IControllerLogService {

	private ControllerLogDao controllerLogDao;
	private ControllerLogMapper mapper;

	@Autowired
	public ControllerLogService(ControllerLogDao controllerLogDao, ControllerLogMapper mapper) {
		this.controllerLogDao = controllerLogDao;
		this.mapper = mapper;
	}

	@Override
	public List<ControllerLogListItemDto> getAll() {
		return controllerLogDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());
	}

	@Override
	public Optional<ControllerLogResponseDto> getById(Integer id) {

		return controllerLogDao.getById(id).map(mapper::toResponse);

	}

	@Override
	public ControllerLogResponseDto insert(ControllerLogCreateDto dto) {

		ControllerLog controllerLog = mapper.toEntity(dto);

		ControllerLog persisted = controllerLogDao.insert(controllerLog);
		return mapper.toResponse(persisted);

	}

	@Override
	public ControllerLogResponseDto update(ControllerLogUpdateDto dto, Integer id) {

		ControllerLog existing = controllerLogDao.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("ControllerLog not found"));

		mapper.updateFromDto(dto, existing);

		ControllerLog persisted = controllerLogDao.update(existing);
		return mapper.toResponse(persisted);

	}

	@Override
	public void delete(Integer id) {
		boolean removed = controllerLogDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("ControllerLog not found");
	}

}
