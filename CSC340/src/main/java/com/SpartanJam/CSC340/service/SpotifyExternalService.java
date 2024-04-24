package com.SpartanJam.CSC340.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.SpartanJam.CSC340.model.Song;
import com.SpartanJam.CSC340.util.SpotifyAccessToken;
import com.SpartanJam.CSC340.util.SpotifyPlaylist;
import com.SpartanJam.CSC340.util.SpotifyTrackItems;
import com.SpartanJam.CSC340.util.SpotifyTracksDetails;

/**
*
* @author NehaChauhan
*/
public class SpotifyExternalService {
	RestTemplate restTemplate;
	
	public SpotifyExternalService() {
		this.restTemplate = new RestTemplate();
	}
	
	public List<Song> getSpotifyTracks() {
		String url = getSpotifyArtists();
		ResponseEntity<SpotifyTracksDetails> res = this.restTemplate.exchange(url, HttpMethod.GET, getSpotifyHttpEntityWithAccessToken(), SpotifyTracksDetails.class);
		List<Song> songs = new ArrayList<>();
		for(SpotifyTrackItems spotifyTrackItems: res.getBody().getItems()) {
			String songName = spotifyTrackItems.getTrack().getName();
			String albumName = spotifyTrackItems.getTrack().getAlbum().getName();
			String artist = spotifyTrackItems.getTrack().getAlbum().getArtists()[0].getName();
			String spotifyUrl = spotifyTrackItems.getTrack().getExternal_urls().getSpotify();
			Song song = new Song(songName,albumName,artist,spotifyUrl);
			songs.add(song);
		}
		return songs;
	}
	
	public String getSpotifyArtists() {
//		String url = "https://api.spotify.com/v1/me";
		String url = "https://api.spotify.com/v1/users/31pqbjacotpxlnseaxwfgbitoiyi/playlists";
//		String url = "https://api.spotify.com/v1/playlists/04MNbYomLouFCIgcxV9RA7/tracks";
//		String url = "https://api.spotify.com/v1/artists/4Z8W4fKeB5YxbusRsdQVPb";
		ResponseEntity<SpotifyPlaylist> res = this.restTemplate.exchange(url, HttpMethod.GET, getSpotifyHttpEntityWithAccessToken(), SpotifyPlaylist.class);

		return res.getBody().getItems()[0].getTracks().getHref();
	}
	
	public String getSpotifyAccessToken() {
		String url = "https://accounts.spotify.com/api/token";
		
		ResponseEntity<SpotifyAccessToken> res = this.restTemplate.exchange(url, HttpMethod.POST, getSpotifyHttpEntity(), SpotifyAccessToken.class);
		return res.getBody().getAccess_token();
	}
	
	public HttpEntity<String> getSpotifyHttpEntity(){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type","application/x-www-form-urlencoded");
		String body = "grant_type=client_credentials&client_id=2cc4c9e5392b4a04a1e59caf9b518e39&client_secret=94f60d30493342b7b9f63d35d996b5e9";
		HttpEntity<String> httpEntity = new HttpEntity<>(body, httpHeaders);
		return httpEntity;
	}
	
	public HttpEntity<String> getSpotifyHttpEntityWithAccessToken(){
		HttpHeaders httpHeaders = new HttpHeaders();
		String accessToken = getSpotifyAccessToken();
		httpHeaders.add("Authorization", "Bearer " + accessToken);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		return httpEntity;
	}

}
