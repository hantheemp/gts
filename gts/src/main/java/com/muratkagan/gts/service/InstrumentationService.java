package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.InstrumentationDao;
import com.muratkagan.gts.dto.InstrumentationCreateDto;
import com.muratkagan.gts.dto.InstrumentationListItemDto;
import com.muratkagan.gts.dto.InstrumentationResponseDto;
import com.muratkagan.gts.dto.InstrumentationUpdateDto;
import com.muratkagan.gts.entities.Instrumentation;
import com.muratkagan.gts.mapper.InstrumentationMapper;

@Service
public class InstrumentationService implements IInstrumentationService {

	private final InstrumentationDao instrumentationDao;
	private final InstrumentationMapper mapper;

	@Autowired
	public InstrumentationService(InstrumentationDao instrumentationDao, InstrumentationMapper mapper) {
		this.instrumentationDao = instrumentationDao;
		this.mapper = mapper;
	}

	@Override
	public List<InstrumentationListItemDto> getAll() {
		return instrumentationDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());
	}

	@Override
	public Optional<InstrumentationResponseDto> getById(Integer id) {
		return instrumentationDao.getById(id).map(mapper::toResponse);
	}

	@Override
	public InstrumentationResponseDto insert(InstrumentationCreateDto dto) {

		Instrumentation instrumentation = mapper.toEntity(dto);

		Instrumentation persisted = instrumentationDao.insert(instrumentation);
		return mapper.toResponse(persisted);

	}

	@Override
	public InstrumentationResponseDto update(InstrumentationUpdateDto dto, Integer id) {

		Instrumentation existing = instrumentationDao.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Instrumentation not found"));

		mapper.updateFromDto(dto, existing);

		Instrumentation persisted = instrumentationDao.insert(existing);
		return mapper.toResponse(persisted);

	}

	@Override
	public void delete(Integer id) {

		boolean removed = instrumentationDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("Genre not found");

	}

}
