package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.muratkagan.gts.dto.APIResponse;
import com.muratkagan.gts.entities.Genre;
import com.muratkagan.gts.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

	private final GenreService genreService;

	@Autowired
	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	// GET all songs
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		List<Genre> genres = genreService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Genres retrieved successfully", genres));
	}

	// GET song by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		Genre genre = genreService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Genre not found with id: " + id));
		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Genre retrieved successfully", genre));
	}

	// POST new song
	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@RequestBody Genre genre) {

		boolean success = genreService.insert(genre);
		if (!success) {
			throw new RuntimeException("Failed to insert album");
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Genre created successfully", genre));
	}

	// PUT update song
	@PutMapping("/update")
	public ResponseEntity<APIResponse> update(@RequestBody Genre genre) {

		boolean success = genreService.update(genre);
		if (!success) {
			throw new RuntimeException("Failed to update album with id: " + genre.getId());
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Genre updated successfully", genre));
	}

	// DELETE song by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		boolean success = genreService.delete(id);
		if (!success) {
			throw new IllegalArgumentException("Genre not found with id: " + id);
		}

		return ResponseEntity.ok(new APIResponse("SUCCESS", 200, "Genre deleted successfully"));
	}
}