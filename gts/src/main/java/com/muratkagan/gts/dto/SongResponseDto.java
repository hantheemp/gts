package com.muratkagan.gts.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class SongResponseDto {

	private Integer id;

	private Integer artistId;

	private Integer albumId;

	private String title;

	private String subtitle;

	private LocalDate releaseDate;

	private Integer durationSeconds;

	private String languageCode;

	private List<String> genres;

	private List<String> instrumentations;

	private List<String> moods;

	// AUDIT FIELDS START

	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;

	// AUDIT FIELDS END

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<String> getInstrumentations() {
		return instrumentations;
	}

	public void setInstrumentations(List<String> instrumentations) {
		this.instrumentations = instrumentations;
	}

	public List<String> getMoods() {
		return moods;
	}

	public void setMoods(List<String> moods) {
		this.moods = moods;
	}
}