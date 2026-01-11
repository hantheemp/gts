package com.muratkagan.gts.dto;

import java.time.OffsetDateTime;
import java.util.Map;

public class ArtistResponseDto {
	private Integer id;
	private String name;
	private String surname;
	private Integer countryId;
	private String countryName;
	private Integer cityId;
	private String cityName;
	private String bio;
	private Map<String, Object> socialLinks;
	private OffsetDateTime createdAt;
	private OffsetDateTime updatedAt;

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

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Map<String, Object> getSocialLinks() {
		return socialLinks;
	}

	public void setSocialLinks(Map<String, Object> socialLinks) {
		this.socialLinks = socialLinks;
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
}