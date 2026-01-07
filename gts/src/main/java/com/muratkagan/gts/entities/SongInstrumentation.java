package com.muratkagan.gts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "song_instrumentations")
public class SongInstrumentation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "song_id")
	private Integer songId;
	
	@Column(name = "instrumentation_id")
	private Integer instrumentationId;

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Integer getInstrumentationId() {
		return instrumentationId;
	}

	public void setInstrumentationId(Integer instrumentationId) {
		this.instrumentationId = instrumentationId;
	}

}
