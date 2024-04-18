package com.SpartanJam.CSC340.util;

/**
*
* @author NehaChauhan
*/
public class SpotifyTracksUrl {
	private String href;
	private int total;
	
	public SpotifyTracksUrl() {
	}

	public SpotifyTracksUrl(String href, int total) {
		this.href = href;
		this.total = total;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
