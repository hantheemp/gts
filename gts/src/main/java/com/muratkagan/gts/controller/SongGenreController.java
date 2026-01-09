package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.entities.SongGenre;
import com.muratkagan.gts.service.SongGenreService;
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/songGenre")
public class SongGenreController {

	private final SongGenreService songGenreService;

	@Autowired
	public SongGenreController(SongGenreService songGenreService) {
		this.songGenreService = songGenreService;
	}

	// GET all songGenres
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<SongGenre> songGenres = songGenreService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song Genres retrieved successfully", songGenres));
	}

	// GET songGenres by Song ID
	@DeleteMapping("/get/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		SongGenre songGenre = songGenreService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Song Genre not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song Genre retrieved successfully", songGenre));
	}

	// POST new songGenres
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody SongGenre songGenre) {
		if (songGenre.getSongId() == null) {
			throw new IllegalArgumentException("Song Genre ID must not be empty");
		}

		boolean success = songGenreService.insert(songGenre);
		if (!success) {
			throw new RuntimeException("Failed to insert song genres");
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song Genre created successfully", songGenre));
	}

	// PUT update songGenre
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody SongGenre songGenre) {
		if (songGenre.getSongId() == null) {
			throw new IllegalArgumentException("Song Genre ID must not be empty");
		}

		boolean success = songGenreService.update(songGenre);
		if (!success) {
			throw new RuntimeException("Failed to update album with id: " + songGenre.getSongId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Album updated successfully", songGenre));
	}

	// DELETE songGenre by Song ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		boolean success = songGenreService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("Song Genre not found with id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song Genre deleted successfully"));
	}
}