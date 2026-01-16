package com.muratkagan.gts.controller;

import java.net.URI;
import java.util.List;

import com.muratkagan.gts.service.MoodService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.muratkagan.gts.dto.*;

@RestController
@RequestMapping("/api/v1/moods")
public class MoodController {

	private final MoodService moodService;

	public MoodController(MoodService moodService) {
		this.moodService = moodService;
	}

	@GetMapping
	public ResponseEntity<APIResponse> getAll() {
		List<MoodListItemDto> items = moodService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Moods retrieved", items));
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		MoodResponseDto dto = moodService.getById(id).orElseThrow(() -> new IllegalArgumentException("Mood not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Mood retrieved", dto));
	}

	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody MoodCreateDto dto) {
		MoodResponseDto inserted = moodService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Mood created", inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody MoodUpdateDto dto) {
		MoodResponseDto updated = moodService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Mood updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		moodService.delete(id);
		return ResponseEntity.noContent().build();
	}
}