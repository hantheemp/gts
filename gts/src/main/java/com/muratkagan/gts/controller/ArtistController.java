package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.entities.Artist;
import com.muratkagan.gts.service.ArtistService;
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/artist")
public class ArtistController {

	private final ArtistService artistService;

	@Autowired
	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	// GET all artists
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<Artist> artists = artistService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Artists retrieved successfully", artists));
	}

	// GET artist by ID
	@GetMapping("/get{id}")
	public ResponseEntity<APIResponse> get(@PathVariable int id) {
		Artist artist = artistService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Artist not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Artist retrieved successfully", artist));
	}

	// POST new artist
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody Artist artist) {
		if (artist.getName() == null || artist.getName().isBlank()) {
			throw new IllegalArgumentException("Artist name must not be empty");
		}
		boolean success = artistService.insert(artist);
		if (!success) {
			throw new RuntimeException("Failed to insert artist");
		}
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Artist created successfully", artist));
	}

	// PUT update artist
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody Artist artist) {
		boolean success = artistService.update(artist);
		if (!success) {
			throw new IllegalArgumentException("Failed to update artist with id: " + artist.getId());
		}
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Artist updated successfully", artist));
	}

	// DELETE artist by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable int id) {
		boolean success = artistService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("Artist not found with id: " + id);
		}
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Artist deleted successfully"));
	}
}