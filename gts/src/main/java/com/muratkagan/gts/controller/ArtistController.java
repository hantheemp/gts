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
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {

	private final ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping
	public ResponseEntity<APIResponse> getAll() {
		List<ArtistListItemDto> items = artistService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Artists retrieved", items));
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		ArtistResponseDto dto = artistService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Artist not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Artist retrieved", dto));
	}

	@PostMapping
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody ArtistCreateDto dto) {
		ArtistResponseDto created = artistService.create(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Artist created", created);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/{id}")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody ArtistUpdateDto dto) {
		ArtistResponseDto updated = artistService.update(id, dto);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Artist updated", updated));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		artistService.delete(id);
		return ResponseEntity.noContent().build();
	}
}