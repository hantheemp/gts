package com.muratkagan.gts.dto;

import java.util.Map;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArtistCreateDto {
	@NotBlank
	@Size(max = 200)
	private String name;

	@Size(max = 200)
	private String surname;

	private Integer countryId;
	private Integer cityId;

	@Size(max = 5000)
	private String bio;

	private Map<String, Object> socialLinks;

	// Getters and setters
	
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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
}