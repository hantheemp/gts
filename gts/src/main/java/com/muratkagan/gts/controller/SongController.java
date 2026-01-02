package com.muratkagan.gts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muratkagan.gts.business.SongService;
import com.muratkagan.gts.entities.Song;

@RestController
public class SongController {

	private final SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@GetMapping("/song/getAll")
	public List<Song> getAll() {
		return songService.getAll();
	}

	@GetMapping("/song/get{id}")
	public Optional<Song> getById(@RequestParam int id) {
		return songService.getById(id);
	}

	@PostMapping("/song/update")
	public boolean update(@RequestBody Song song) {
		return songService.update(song);
	}

	@DeleteMapping("/song/delete{id}")
	public boolean delete(@RequestParam int id) {
		return songService.delete(id);
	}

}
