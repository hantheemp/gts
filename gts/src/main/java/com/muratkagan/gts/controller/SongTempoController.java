package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.dto.APIResponse;
import com.muratkagan.gts.entities.SongTempo;
import com.muratkagan.gts.service.SongTempoService;

@RestController
@RequestMapping("/songTempo")
public class SongTempoController {

	private final SongTempoService songTempoService;

	@Autowired
	public SongTempoController(SongTempoService songTempoService) {
		this.songTempoService = songTempoService;
	}

	// GET all songTempos
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<SongTempo> songTempo = songTempoService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongTempos retrieved successfully", songTempo));
	}

	// GET songTempo by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		SongTempo songTempo = songTempoService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("SongTempo not found with id: " + id));
		return ResponseEntity
				.ok(new APIResponse("SUCCESS", 200, "SongInstrumentation retrieved successfully", songTempo));
	}

	// POST new songTempo
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody SongTempo songTempo) {
		if (songTempo.getSongId() == null) {
			throw new IllegalArgumentException("Song ID must not be empty");
		}

		boolean success = songTempoService.insert(songTempo);
		if (!success) {
			throw new RuntimeException("Failed to insert SongTempo");
		}

		return ResponseEntity
				.ok(new APIResponse("SUCCESS", 200, "SongInstrumentation created successfully", songTempo));
	}

	// PUT update songTempo
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody SongTempo songTempo) {
		if (songTempo.getSongId() == null) {
			throw new IllegalArgumentException("Song ID must not be empty");
		}

		boolean success = songTempoService.update(songTempo);
		if (!success) {
			throw new RuntimeException("Failed to update SongTempo with Song id: " + songTempo.getSongId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongTempo updated successfully", songTempo));
	}

	// DELETE songTempo by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		boolean success = songTempoService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("SongTempo not found with Song id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "SongTempo deleted successfully"));
	}
}