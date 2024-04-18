package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifySong {
	private String spotify;

	public SpotifySong() {
	}

	public SpotifySong(String spotify) {
		super();
		this.spotify = spotify;
	}

	public String getSpotify() {
		return spotify;
	}

	public void setSpotify(String spotify) {
		this.spotify = spotify;
	}
}
