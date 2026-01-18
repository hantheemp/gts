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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/instrumentations", produces = "application/json")
@Tag(name = "Instrumentations", description = "Instrumentation management APIs")
public class InstrumentationController {

	private final InstrumentationService instrumentationService;

	public InstrumentationController(InstrumentationService instrumentationService) {
		this.instrumentationService = instrumentationService;
	}

	@GetMapping
	@Operation(summary = "Get all instrumentations", description = "Retrieves all instrumentations persisted to Postgre.")
	public ResponseEntity<APIResponse> getAll() {
		List<InstrumentationListItemDto> items = instrumentationService.getAll();
		return ResponseEntity
				.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Instrumentations retrieved", items));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get instrumentation by ID", description = "Retrieves an instrumentation by its ID.")
	public ResponseEntity<APIResponse> get(@PathVariable Integer id) {
		InstrumentationResponseDto dto = instrumentationService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Instrumentation not found"));
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Instrumentation retrieved", dto));
	}

	@PostMapping("/insert")
	@Operation(summary = "Insert a new instrumentation", description = "Creates a new instrumentation entry.")
	public ResponseEntity<APIResponse> insert(@Valid @RequestBody InstrumentationCreateDto dto) {
		InstrumentationResponseDto inserted = instrumentationService.insert(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inserted.getId())
				.toUri();
		APIResponse payload = new APIResponse("SUCCESS", HttpStatus.CREATED.value(), "Instrumentation created",
				inserted);
		return ResponseEntity.created(location).body(payload);
	}

	@PutMapping("/update/{id}")
	@Operation(summary = "Update an instrumentation", description = "Updates an existing instrumentation entry.")
	public ResponseEntity<APIResponse> update(@PathVariable Integer id,
			@Valid @RequestBody InstrumentationUpdateDto dto) {
		InstrumentationResponseDto updated = instrumentationService.update(dto, id);
		return ResponseEntity.ok(new APIResponse("SUCCESS", HttpStatus.OK.value(), "Instrumentation updated", updated));
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete an instrumentation", description = "Deletes an instrumentation by its ID.")
	public ResponseEntity<APIResponse> delete(@PathVariable Integer id) {
		instrumentationService.delete(id);
		return ResponseEntity.noContent().build();
	}
}