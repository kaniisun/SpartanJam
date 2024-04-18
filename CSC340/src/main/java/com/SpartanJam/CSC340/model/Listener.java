/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author sreyk
 */
@Entity
public class Listener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String username;
    @NotNull
	private String songName;
    @NotNull
	private String albumName;
    @NotNull
	private String artistName;
    @NotNull
	private String spotifyUrl;
    
    public Listener() {
	}
    
	public Listener(int id, @NotNull String username, @NotNull String songName, @NotNull String albumName,
			@NotNull String artistName, @NotNull String spotifyUrl) {
		super();
		this.id = id;
		this.username = username;
		this.songName = songName;
		this.albumName = albumName;
		this.artistName = artistName;
		this.spotifyUrl = spotifyUrl;
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
    	return "ID: " + this.id + ", Username: " + this.username + ", Song: " + this.songName + ", Artist: " + this.artistName 
    			+ ", Album: " + this.albumName + ", URL: " + this.spotifyUrl;
    }
}
