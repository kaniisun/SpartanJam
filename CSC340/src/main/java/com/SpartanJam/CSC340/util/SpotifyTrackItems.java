package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifyTrackItems {
	private SpotifyTrack track;

	public SpotifyTrackItems() {
	}

	public SpotifyTrackItems(SpotifyTrack track) {
		super();
		this.track = track;
	}

	public SpotifyTrack getTrack() {
		return track;
	}

	public void setTrack(SpotifyTrack track) {
		this.track = track;
	}
}
