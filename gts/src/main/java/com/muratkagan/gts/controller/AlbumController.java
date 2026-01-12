package com.muratkagan.gts.controller;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.service.AlbumService;
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

	private final AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}

	@GetMapping
	public ResponseEntity<APIResponse> getAll() {
		List<AlbumListItemDto> items = albumService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Albums retrieved", items));
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		AlbumResponseDto dto = albumService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Album not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Album retrieved", dto));
	}

	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody AlbumCreateDto dto) {
		AlbumResponseDto inserted = albumService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Album created", inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody AlbumUpdateDto dto) {
		AlbumResponseDto updated = albumService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Album updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		albumService.delete(id);
		return ResponseEntity.noContent().build();
	}
}