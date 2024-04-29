package com.SpartanJam.CSC340.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class Song {
	private String songName;
	private String albumName;
	private String artistName;
	private String spotifyUrl;
	
	
	public Song() {
	}
	
	public Song(String songName, String albumName, String artistName, String spotifyUrl) {
		super();
		this.songName = songName;
		this.albumName = albumName;
		this.artistName = artistName;
		this.spotifyUrl = spotifyUrl;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getSpotifyUrl() {
		return spotifyUrl;
	}

	public void setSpotifyUrl(String spotifyUrl) {
		this.spotifyUrl = spotifyUrl;
	}
	
	@Override
	public String toString() {
		return "Song: " + this.songName + ", Album: " + this.albumName + ", Artist: " + this.artistName + ", Spotify URL: " + this.spotifyUrl;
	}
}
