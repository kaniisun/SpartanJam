package com.SpartanJam.CSC340.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
*
* @author NehaChauhan
*/
@Entity
public class LocalListener {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @NotNull
    private String username;
    @NotNull
	private String title;
    @NotNull
    private String audioFilePath;
	private String artistName;
    private Character rating;
    
	public LocalListener() {

	}

	public LocalListener(int id, @NotNull String username, @NotNull String title, @NotNull String audioFilePath,
			String artistName, Character rating) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.audioFilePath = audioFilePath;
		this.artistName = artistName;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAudioFilePath() {
		return audioFilePath;
	}

	public void setAudioFilePath(String audioFilePath) {
		this.audioFilePath = audioFilePath;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Character getRating() {
		return rating;
	}

	public void setRating(Character rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + ", Username: " + this.username + ", Title: " + this.title + ", Artist: " + this.artistName + ", Path: " + this.audioFilePath;
	}
}
