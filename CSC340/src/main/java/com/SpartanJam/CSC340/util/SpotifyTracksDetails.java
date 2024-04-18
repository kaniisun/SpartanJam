package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifyTracksDetails {
	private SpotifyTrackItems[] items;
	private int total;
	
	public SpotifyTracksDetails() {
	}

	public SpotifyTracksDetails(SpotifyTrackItems[] items, int total) {
		super();
		this.items = items;
		this.total = total;
	}

	public SpotifyTrackItems[] getItems() {
		return items;
	}

	public void setItems(SpotifyTrackItems[] items) {
		this.items = items;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
