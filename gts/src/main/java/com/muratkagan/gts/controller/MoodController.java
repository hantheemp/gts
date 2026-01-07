package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.muratkagan.gts.dto.APIResponse;
import com.muratkagan.gts.entities.Mood;
import com.muratkagan.gts.service.MoodService;

@RestController
@RequestMapping("/mood")
public class MoodController {

	private final MoodService moodService;

	@Autowired
	public MoodController(MoodService moodService) {
		this.moodService = moodService;
	}

	// GET all moods
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<Mood> moods = moodService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Moods retrieved successfully", moods));
	}

	// GET mood by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		Mood mood = moodService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Mood not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Mood retrieved successfully", mood));
	}

	// POST new mood
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody Mood mood) {
		if (mood.getId() == null) {
			throw new IllegalArgumentException("Mood ID must not be empty");
		}
		boolean success = moodService.insert(mood);
		if (!success) {
			throw new RuntimeException("Failed to insert mood");
		}
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Mood created successfully", mood));
	}

	// PUT update mood
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody Mood mood) {
		boolean success = moodService.update(mood);
		if (!success) {
			throw new IllegalArgumentException("Failed to update mood with id: " + mood.getId());
		}
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Mood updated successfully", mood));
	}

	// DELETE mood by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		boolean success = moodService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("Mood not found with id: " + id);
		}
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Mood deleted successfully"));
	}
}