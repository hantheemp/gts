package com.muratkagan.gts.controller;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.service.SongService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping(value = "/api/v1/songs", produces = "application/json")
@Tag(name = "Songs", description = "Song management APIs")
public class SongController {

	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@GetMapping
	@Operation(summary = "Get all songs", description = "Gets all songs persisted to Postgre.")
	public ResponseEntity<APIResponse> getAll() {
		List<SongListItemDto> items = songService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Songs retrieved", items));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get song by ID", description = "Gets song persisted to Postgre with specified ID.")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		SongResponseDto dto = songService.getById(id).orElseThrow(() -> new IllegalArgumentException("Song not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Song retrieved", dto));
	}

	@PostMapping("/insert")
	@Operation(summary = "Insert a new song", description = "Creates a new song with genres, moods, instrumentations, and artist associations.")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody SongCreateDto dto) {
		SongResponseDto created = songService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Song created", created);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	@Operation(summary = "Update a song", description = "Updates a song with genres, moods, instrumentations, and artist associations.")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody SongUpdateDto dto) {
		SongResponseDto updated = songService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Song updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete a song", description = "Deletes a song that is persisted to Postgre with specified ID.")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		songService.delete(id);
		return ResponseEntity.noContent().build();
	}
}