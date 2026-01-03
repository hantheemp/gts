package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.entities.Song;
import com.muratkagan.gts.service.SongService;
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/song")
public class SongController {

	private final SongService songService;

	@Autowired
	public SongController(SongService songService) {
		this.songService = songService;
	}

	// GET all songs
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<Song> songs = songService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Songs retrieved successfully", songs));
	}

	// GET song by ID
	@GetMapping("/get/")
	public ResponseEntity<APIResponse> get(@RequestParam Integer id) {
		Song song = songService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Song not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song retrieved successfully", song));
	}

	// POST new song
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody Song song) {
		if (song.getTitle() == null || song.getTitle().isBlank()) {
			throw new IllegalArgumentException("Song title must not be empty");
		}
		if (song.getArtistId() == null) {
			throw new IllegalArgumentException("Artist ID must not be empty");
		}

		boolean success = songService.insert(song);
		if (!success) {
			throw new RuntimeException("Failed to insert song");
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song created successfully", song));
	}

	// PUT update song
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody Song song) {
		if (song.getId() == null) {
			throw new IllegalArgumentException("Song ID must not be empty");
		}

		boolean success = songService.update(song);
		if (!success) {
			throw new RuntimeException("Failed to update song with id: " + song.getId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song updated successfully", song));
	}

	// DELETE song by ID
	@DeleteMapping("/delete/")
	public ResponseEntity<APIResponse> delete(@RequestParam Integer id) {
		boolean success = songService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("Song not found with id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Song deleted successfully"));
	}
}