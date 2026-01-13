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
import com.muratkagan.gts.dto.APIResponse;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

	private final GenreService genreService;

	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping
	public ResponseEntity<APIResponse> getAll() {
		List<GenreListItemDto> items = genreService.getAll();
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Genres retrieved", items));
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		GenreResponseDto dto = genreService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Genre not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Genre retrieved", dto));
	}

	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody GenreCreateDto dto) {
		GenreResponseDto inserted = genreService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Genre created", inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id, @Valid @RequestBody GenreUpdateDto dto) {
		GenreResponseDto updated = genreService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Genre updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		genreService.delete(id);
		return ResponseEntity.noContent().build();
	}
}