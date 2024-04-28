package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifyPlaylistItems {
	private String name;
	private SpotifyTracksUrl tracks;
	
	public SpotifyPlaylistItems() {
	}

	public SpotifyPlaylistItems(String name, SpotifyTracksUrl tracks) {
		super();
		this.name = name;
		this.tracks = tracks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpotifyTracksUrl getTracks() {
		return tracks;
	}

	public void setTracks(SpotifyTracksUrl tracks) {
		this.tracks = tracks;
	}
}

