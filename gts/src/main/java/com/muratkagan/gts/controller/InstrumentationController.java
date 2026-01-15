package com.muratkagan.gts.controller;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.muratkagan.gts.dto.*;
import com.muratkagan.gts.dto.APIResponse;
import com.muratkagan.gts.service.InstrumentationService;

@RestController
@RequestMapping("/api/v1/instrumentations")
public class InstrumentationController {

	private final InstrumentationService instrumentationService;

	public InstrumentationController(InstrumentationService instrumentationService) {
		this.instrumentationService = instrumentationService;
	}

	@GetMapping
	public ResponseEntity<APIResponse> getAll() {
		List<InstrumentationListItemDto> items = instrumentationService.getAll();
		return ResponseEntity
				.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Instrumentations retrieved", items));
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		InstrumentationResponseDto dto = instrumentationService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Instrumentation not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Instrumentation retrieved", dto));
	}

	@PostMapping("/insert")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody InstrumentationCreateDto dto) {
		InstrumentationResponseDto inserted = instrumentationService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Instrumentation created",
				inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id,
			@Valid @RequestBody InstrumentationUpdateDto dto) {
		InstrumentationResponseDto updated = instrumentationService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Instrumentation updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		instrumentationService.delete(id);
		return ResponseEntity.noContent().build();
	}
}