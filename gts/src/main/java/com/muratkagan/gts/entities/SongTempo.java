package com.muratkagan.gts.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "song_tempos")
public class SongTempo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "song_id")
	private Integer songId;

	@Column(name = "bpm")
	private Integer bpm;

	@Column(name = "tempo_band")
	private String tempoBand;

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Integer getBpm() {
		return bpm;
	}

	public void setBpm(Integer bpm) {
		this.bpm = bpm;
	}

	public String getTempoBand() {
		return tempoBand;
	}

	public void setTempoBand(String tempoBand) {
		this.tempoBand = tempoBand;
	}

}
