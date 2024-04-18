package com.SpartanJam.CSC340.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpartanJam.CSC340.model.Listener;
import com.SpartanJam.CSC340.repository.ListenerRepository;

/**
*
* @author NehaChauhan
*/
@Service
public class ListenerService {
	@Autowired
	ListenerRepository listenerRepository;
	
	public List<Listener> getAllListenersByUsername(String username){
		List<Listener> listeners = listenerRepository.getAllListenersByUsername(username)
							.orElseThrow(() -> new UsernameNotFoundException("Listener not found for username: " + username));
		return listeners;
	}
	
	public void addFavSong(Listener listener) {
		Listener listener2 = null;
		try {
			listener2 = listenerRepository.findListernerByUsernameAndSongName(listener.getUsername(), listener.getSongName())
					.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		if(listener2 == null) {
			listenerRepository.save(listener);
		}
	}
	
	public void removeFavSong(int id) {
		listenerRepository.deleteById(String.valueOf(id));
	}
}
