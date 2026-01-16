package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;

import com.muratkagan.gts.dto.*;

public interface IMoodService {

	List<MoodListItemDto> getAll();

	Optional<MoodResponseDto> getById(Integer id);

	MoodResponseDto insert(MoodCreateDto dto);

	MoodResponseDto update(MoodUpdateDto dto, Integer id);

	void delete(Integer id);

}
