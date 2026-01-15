package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.InstrumentationCreateDto;
import com.muratkagan.gts.dto.InstrumentationListItemDto;
import com.muratkagan.gts.dto.InstrumentationResponseDto;
import com.muratkagan.gts.dto.InstrumentationUpdateDto;

public interface IInstrumentationService {

	List<InstrumentationListItemDto> getAll();

	Optional<InstrumentationResponseDto> getById(Integer id);

	InstrumentationResponseDto insert(InstrumentationCreateDto dto);

	InstrumentationResponseDto update(InstrumentationUpdateDto dto, Integer id);

	void delete(Integer id);

}
