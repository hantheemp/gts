package com.muratkagan.gts.controller;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.service.ArtistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping(value = "/api/v1/artists" , produces = "application/json")
@Tag(name = "Artists", description = "Artist management APIs")
public class ArtistController {

	private final ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping
	@Operation(summary = "Get all artists", description = "Retrieves all artists persisted to Postgre.")
	public ResponseEntity<APIResponse> getAll() {
		List<ArtistListItemDto> items = artistService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Artists retrieved", items));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get artist by ID", description = "Retrieves an artist by its ID.")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		ArtistResponseDto dto = artistService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Artist retrieved", dto));
	}

	@PostMapping("/insert")
	@Operation(summary = "Insert a new artist", description = "Creates a new artist entry.")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody ArtistCreateDto dto) {
		ArtistResponseDto inserted = artistService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Artist created", inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	@Operation(summary = "Update an artist", description = "Updates an existing artist entry.")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody ArtistUpdateDto dto) {
		ArtistResponseDto updated = artistService.update(id, dto);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Artist updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete an artist", description = "Deletes an artist by its ID.")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		artistService.delete(id);
		return ResponseEntity.noContent().build();
	}
}