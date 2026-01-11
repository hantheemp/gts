package com.muratkagan.gts.dto;

import jakarta.validation.constraints.*;

public class AlbumListItemDto {

    @NotNull
    private Integer id;

    @NotNull
    private Integer artistId;

    @NotBlank
    private String title;

    private String coverArtUrl;
    
    // Getters and setters

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverArtUrl() {
		return coverArtUrl;
	}

	public void setCoverArtUrl(String coverArtUrl) {
		this.coverArtUrl = coverArtUrl;
	}

}