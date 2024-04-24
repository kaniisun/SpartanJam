package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifyPlaylist {
	private SpotifyPlaylistItems[] items;
	private int total;
	
	public SpotifyPlaylist() {
	}

	public SpotifyPlaylist(SpotifyPlaylistItems[] items, int total) {
		super();
		this.items = items;
		this.total = total;
	}

	public SpotifyPlaylistItems[] getItems() {
		return items;
	}

	public void setItems(SpotifyPlaylistItems[] items) {
		this.items = items;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}