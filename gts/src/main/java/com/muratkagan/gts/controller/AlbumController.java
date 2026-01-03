package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.entities.Album;
import com.muratkagan.gts.service.AlbumService;
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/album")
public class AlbumController {

	private final AlbumService albumService;

	@Autowired
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}

	// GET all songs
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<Album> songs = albumService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Albums retrieved successfully", songs));
	}

	// GET song by ID
	@GetMapping("/get/")
	public ResponseEntity<APIResponse> get(@RequestParam Integer id) {
		Album album = albumService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Album not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Album retrieved successfully", album));
	}

	// POST new song
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody Album album) {
		if (album.getTitle() == null || album.getTitle().isBlank()) {
			throw new IllegalArgumentException("Album title must not be empty");
		}
		if (album.getArtistId() == null) {
			throw new IllegalArgumentException("Artist ID must not be empty");
		}

		boolean success = albumService.insert(album);
		if (!success) {
			throw new RuntimeException("Failed to insert album");
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Album created successfully", album));
	}

	// PUT update song
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody Album album) {
		if (album.getId() == null) {
			throw new IllegalArgumentException("Album ID must not be empty");
		}

		boolean success = albumService.update(album);
		if (!success) {
			throw new RuntimeException("Failed to update album with id: " + album.getId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Album updated successfully", album));
	}

	// DELETE song by ID
	@DeleteMapping("/delete/")
	public ResponseEntity<APIResponse> delete(@RequestParam Integer id) {
		boolean success = albumService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("Album not found with id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Album deleted successfully"));
	}
}