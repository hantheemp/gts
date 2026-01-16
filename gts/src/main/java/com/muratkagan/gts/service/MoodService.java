package com.muratkagan.gts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.muratkagan.gts.dto.MoodCreateDto;
import com.muratkagan.gts.dto.MoodListItemDto;
import com.muratkagan.gts.dto.MoodResponseDto;
import com.muratkagan.gts.dto.MoodUpdateDto;
import com.muratkagan.gts.mapper.MoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratkagan.gts.dao.MoodDao;
import com.muratkagan.gts.entities.Mood;

import javax.swing.text.html.Option;

@Service
public class MoodService implements IMoodService {

	private final MoodDao moodDao;
	private final MoodMapper mapper;

	@Autowired
	public MoodService(MoodDao moodDao, MoodMapper mapper){
		this.moodDao = moodDao;
		this.mapper = mapper;
	}

	@Override
	public List<MoodListItemDto> getAll() {

		return moodDao.getAll().stream().map(mapper::toListItem).collect(Collectors.toList());

	}

	@Override
	public Optional<MoodResponseDto> getById(Integer id) {

		return moodDao.getById(id).map(mapper::toResponse);

	}

	@Override
	public MoodResponseDto insert(MoodCreateDto dto) {

		Mood mood = mapper.toEntity(dto);

		Mood persisted = moodDao.insert(mood);
		return mapper.toResponse(persisted);

	}

	@Override
	public MoodResponseDto update(MoodUpdateDto dto, Integer id) {

		Mood existing = moodDao.getById(id).orElseThrow(() -> new IllegalArgumentException("Mood not found"));

		mapper.updateFromDto(dto, existing);

		Mood persisted = moodDao.update(existing);
		return mapper.toResponse(persisted);

	}

	@Override
	public void delete(Integer id) {
		boolean removed = moodDao.delete(id);
		if (!removed)
			throw new IllegalArgumentException("Mood not found");
	}
}
