package com.muratkagan.gts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muratkagan.gts.business.ArtistService;
import com.muratkagan.gts.entities.Artist;

@RestController
public class ArtistController {

	private final ArtistService artistService;

	@Autowired
	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping("/artist/getAll")
	public List<Artist> getAll() {
		return artistService.getAll();
	}

	@GetMapping("/artist/get{id}")
	public Optional<Artist> get(@RequestParam int id) {
		return artistService.getById(id);
	}
	
	@PostMapping("/artist/insert")
	public boolean insert(@RequestBody Artist artist) {
		return artistService.insert(artist);
	}

	@PostMapping("/artist/update")
	public boolean update(@RequestBody Artist artist) {
		return artistService.update(artist);
	}

	@DeleteMapping("/artist/delete{id}")
	public boolean delete(@RequestParam int id) {
		return artistService.delete(id);
	}

}
