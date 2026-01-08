package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.entities.SongMood;
import com.muratkagan.gts.service.SongMoodService;
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/songMood")
public class SongMoodController {

	private final SongMoodService songMoodService;

	@Autowired
	public SongMoodController(SongMoodService songMoodService) {
		this.songMoodService = songMoodService;
	}

	// GET all songs
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<SongMood> songMoods = songMoodService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongMoods retrieved successfully", songMoods));
	}

	// GET song by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		SongMood songMood = songMoodService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("SongMood not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongMood retrieved successfully", songMood));
	}

	// POST new song
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody SongMood songMood) {
		if (songMood.getSongId() == null) {
			throw new IllegalArgumentException("Song ID must not be empty");
		}
		if (songMood.getMoodId() == null) {
			throw new IllegalArgumentException("Mood ID must not be empty");
		}

		boolean success = songMoodService.insert(songMood);
		if (!success) {
			throw new RuntimeException("Failed to insert Song Mood");
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongMood created successfully", songMood));
	}

	// PUT update song
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody SongMood songMood) {
		if (songMood.getSongId() == null) {
			throw new IllegalArgumentException("SongMood ID must not be empty");
		}

		boolean success = songMoodService.update(songMood);
		if (!success) {
			throw new RuntimeException("Failed to update SongMood with id: " + songMood.getSongId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongMood updated successfully", songMood));
	}

	// DELETE song by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		boolean success = songMoodService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("SongMood not found with id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongMood deleted successfully"));
	}
}