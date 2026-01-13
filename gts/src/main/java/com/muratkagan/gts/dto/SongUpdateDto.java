package com.muratkagan.gts.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SongUpdateDto {

	@NotNull(message = "Artist ID is required")
	private Integer artistId;

	private Integer albumId;

	@NotBlank(message = "Title is required")
	@Size(max = 200, message = "Title must be at most 200 characters")
	private String title;

	@Size(max = 200, message = "Subtitle must be at most 200 characters")
	private String subtitle;

	@NotNull(message = "Release date is required")
	private LocalDate releaseDate;

	@Min(value = 1, message = "Duration must be at least 1 second")
	private Integer durationSeconds;

	@Size(max = 3, message = "Language code must be short (e.g., 'en', 'tr')")
	private String languageCode;

	private List<Integer> genreIds;

	// Getters and setters

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getDurationSeconds() {
		return durationSeconds;
	}

	public void setDurationSeconds(Integer durationSeconds) {
		this.durationSeconds = durationSeconds;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

}