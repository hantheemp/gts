package com.muratkagan.gts.dto;

import java.time.OffsetDateTime;

public class ArtistListItemDto {
	private Integer id;
	private String name;
	private String surname;
	private String countryName;
	private Integer songCount;
	private OffsetDateTime createdAt;

	// Getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getSongCount() {
		return songCount;
	}

	public void setSongCount(Integer songCount) {
		this.songCount = songCount;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
}