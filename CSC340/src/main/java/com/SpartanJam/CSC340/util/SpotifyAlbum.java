package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifyAlbum {
	private SpotifyArtist[] artists;
	private String name;
	
	public SpotifyAlbum() {
	}

	public SpotifyAlbum(SpotifyArtist[] artists, String name) {
		super();
		this.artists = artists;
		this.name = name;
	}

	public SpotifyArtist[] getArtists() {
		return artists;
	}

	public void setArtists(SpotifyArtist[] artists) {
		this.artists = artists;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
