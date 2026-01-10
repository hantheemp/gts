package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.dto.APIResponse;
import com.muratkagan.gts.entities.SongInstrumentation;
import com.muratkagan.gts.service.SongInstrumentationService;

@RestController
@RequestMapping("/songInstrumentation")
public class SongInstrumentationController {

	private final SongInstrumentationService songInstrumentationService;

	@Autowired
	public SongInstrumentationController(SongInstrumentationService songInstrumentationService) {
		this.songInstrumentationService = songInstrumentationService;
	}

	// GET all songInstrumentations
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<SongInstrumentation> songInstrumentations = songInstrumentationService.getAll();
		return ResponseEntity.ok(
				new APIResponse("SUCCESS", 200, "SongInstrumentations retrieved successfully", songInstrumentations));
	}

	// GET songInstrumentation by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		SongInstrumentation songInstrumentation = songInstrumentationService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("SongMood not found with id: " + id));
		return ResponseEntity
				.ok(new APIResponse("SUCCESS", 200, "SongInstrumentation retrieved successfully", songInstrumentation));
	}

	// POST new songInstrumentation
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody SongInstrumentation songInstrumentation) {
		if (songInstrumentation.getSongId() == null) {
			throw new IllegalArgumentException("Song ID must not be empty");
		}
		if (songInstrumentation.getInstrumentationId() == null) {
			throw new IllegalArgumentException("Instrumentation ID must not be empty");
		}

		boolean success = songInstrumentationService.insert(songInstrumentation);
		if (!success) {
			throw new RuntimeException("Failed to insert SongInstrumentation");
		}

		return ResponseEntity
				.ok(new APIResponse("SUCCESS", 200, "SongInstrumentation created successfully", songInstrumentation));
	}

	// PUT update songInstrumentation
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody SongInstrumentation songInstrumentation) {
		if (songInstrumentation.getSongId() == null) {
			throw new IllegalArgumentException("SongMood ID must not be empty");
		}

		boolean success = songInstrumentationService.update(songInstrumentation);
		if (!success) {
			throw new RuntimeException(
					"Failed to update SongInstrumentation with id: " + songInstrumentation.getSongId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongMood updated successfully", songInstrumentation));
	}

	// DELETE songInstrumentation by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		boolean success = songInstrumentationService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("SongInstrumentation not found with Song id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongInstrumentation deleted successfully"));
	}
}