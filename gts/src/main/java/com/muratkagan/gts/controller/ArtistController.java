package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muratkagan.gts.business.ArtistService;
import com.muratkagan.gts.entities.Artist;

@RestController
public class ArtistController {

	private final ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping("/artist/getAll")
	public List<Artist> getAll() {
		return artistService.getAll();
	}

}
