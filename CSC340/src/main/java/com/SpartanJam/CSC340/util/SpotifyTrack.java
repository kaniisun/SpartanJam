package com.SpartanJam.CSC340.util;

import lombok.Data;

/**
*
* @author NehaChauhan
*/
public class SpotifyTrack {
	private SpotifyAlbum album;
	private SpotifySong external_urls;
	private String name;
	
	public SpotifyTrack() {
	}

	public SpotifyTrack(SpotifyAlbum album, SpotifySong external_urls, String name) {
		super();
		this.album = album;
		this.external_urls = external_urls;
		this.name = name;
	}

	public SpotifyAlbum getAlbum() {
		return album;
	}

	public void setAlbum(SpotifyAlbum album) {
		this.album = album;
	}

	public SpotifySong getExternal_urls() {
		return external_urls;
	}

	public void setExternal_urls(SpotifySong external_urls) {
		this.external_urls = external_urls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
