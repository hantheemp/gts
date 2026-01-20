package com.muratkagan.gts.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public class AlbumCreateDto {

	@NotNull(message = "Artist ID is required")
	private Integer artistId;

	@NotBlank(message = "Title is required")
	@Size(max = 200, message = "Title must be at most 200 characters")
	private String title;

	@NotNull(message = "Release date is required")
	private LocalDate releaseDate;

	@Size(max = 500, message = "Cover art URL must be at most 500 characters")
	private String coverArtUrl;

	// Getters and setters

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCoverArtUrl() {
		return coverArtUrl;
	}

	public void setCoverArtUrl(String coverArtUrl) {
		this.coverArtUrl = coverArtUrl;
	}

}