package com.SpartanJam.CSC340.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpartanJam.CSC340.model.ArtistSong;
import com.SpartanJam.CSC340.repository.SongRepository;

/**
*
* @author NehaChauhan
*/
@Service
public class SongService {
	
	@Autowired
	SongRepository songRepository;
	
	public List<ArtistSong> getAllArtistSongs(){
		List<ArtistSong> listOfSongs  = null;
				
		try {
			listOfSongs = (List<ArtistSong>) songRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listOfSongs;
	}

}
