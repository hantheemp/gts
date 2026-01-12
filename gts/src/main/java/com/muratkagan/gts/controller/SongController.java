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
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {

	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@GetMapping
	public ResponseEntity<APIResponse> getAll() {
		List<SongListItemDto> items = songService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Songs retrieved", items));
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		SongResponseDto dto = songService.getById(id).orElseThrow(() -> new IllegalArgumentException("Song not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Song retrieved", dto));
	}

	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody SongCreateDto dto) {
		SongResponseDto created = songService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Song created", created);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody SongUpdateDto dto) {
		SongResponseDto updated = songService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Song updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		songService.delete(id);
		return ResponseEntity.noContent().build();
	}
}