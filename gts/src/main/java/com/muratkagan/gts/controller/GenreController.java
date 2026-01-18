package com.muratkagan.gts.controller;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.service.GenreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping(value = "/api/v1/genres", produces = "application/json")
@Tag(name = "Genres", description = "Genre management APIs")
public class GenreController {

	private final GenreService genreService;

	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping
	@Operation(summary = "Get all genres", description = "Retrieves all genres persisted to Postgre.")
	public ResponseEntity<APIResponse> getAll() {
		List<GenreListItemDto> items = genreService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Genres retrieved", items));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get genre by ID", description = "Retrieves a genre by its ID.")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		GenreResponseDto dto = genreService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Genre not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Genre retrieved", dto));
	}

	@PostMapping("/insert")
	@Operation(summary = "Insert a new genre", description = "Creates a new genre entry.")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody GenreCreateDto dto) {
		GenreResponseDto inserted = genreService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Genre created", inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	@Operation(summary = "Update a genre", description = "Updates an existing genre entry.")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody GenreUpdateDto dto) {
		GenreResponseDto updated = genreService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Genre updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete a genre", description = "Deletes a genre by its ID.")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		genreService.delete(id);
		return ResponseEntity.noContent().build();
	}
}