package com.muratkagan.gts.lib;

import com.muratkagan.gts.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.dao.DataIntegrityViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Bad arguments passed to methods
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<APIResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new APIResponse("ERROR", 400, "Invalid argument: " + ex.getMessage()));
	}

	// Validation errors on @Valid annotated request bodies
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<APIResponse> handleValidationException(MethodArgumentNotValidException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new APIResponse("ERROR", 400, "Validation failed: " + ex.getMessage()));
	}

	// Missing required query parameters
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<APIResponse> handleMissingParam(MissingServletRequestParameterException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new APIResponse("ERROR", 400, "Missing parameter: " + ex.getParameterName()));
	}

	// Wrong type for query/path parameters
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<APIResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse("ERROR", 400,
				"Type mismatch: " + ex.getName() + " should be of type " + ex.getRequiredType()));
	}

	// Malformed JSON request body
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<APIResponse> handleUnreadableMessage(HttpMessageNotReadableException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new APIResponse("ERROR", 400, "Malformed JSON request: " + ex.getMessage()));
	}

	// Wrong HTTP method (e.g., POST instead of GET)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<APIResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
				.body(new APIResponse("ERROR", 405, "Method not supported: " + ex.getMethod()));
	}

	// Unsupported content type
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<APIResponse> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.body(new APIResponse("ERROR", 415, "Unsupported media type: " + ex.getContentType()));
	}

	// Unsupported response type requested
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ResponseEntity<APIResponse> handleMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.body(new APIResponse("ERROR", 406, "Media type not acceptable: " + ex.getMessage()));
	}

	// Database constraint violations
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<APIResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new APIResponse("ERROR", 409, "Database error: " + ex.getMessage()));
	}

	// Catch-all for any other exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse> handleGeneralException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new APIResponse("ERROR", 500, "An unexpected error occurred: " + ex.getMessage()));
	}
}