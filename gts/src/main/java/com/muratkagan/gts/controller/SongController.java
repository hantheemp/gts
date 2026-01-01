package com.muratkagan.gts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Song> getAll(){
		return songService.getAll();
	}

}
