package com.SpartanJam.CSC340.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpartanJam.CSC340.model.LocalListener;
import com.SpartanJam.CSC340.repository.LocalListenerRepository;

/**
*
* @author NehaChauhan
*/
@Service
public class LocalListenerService {
	@Autowired
	LocalListenerRepository localListenerRepository;
	
	public List<LocalListener> getAllLocalListenersByUsername(String username){
		List<LocalListener> localListeners = localListenerRepository.getAllLocalListenersByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Listener not found for username: " + username));
		return localListeners;
	}
	
	public void addLocFavSong(LocalListener localListener) {
		LocalListener localListener2 = null;
		try {
			localListener2 = localListenerRepository.findLocalListenerByUsernameAndTitle(localListener.getUsername(), localListener.getTitle())
					.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		}catch(Exception e) {
//			e.printStackTrace();
		}
			
		if(localListener2 == null) {
			localListenerRepository.save(localListener);
		}
	}
	
	public void removeLocFavSong(int id) {
		localListenerRepository.deleteById(id);
	}
	
	public LocalListener getLocListenerById(int id) {
		LocalListener localListener = localListenerRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Local Listener not found for id: " + id));
		
		return localListener;
	}
	
	public void updateLocalListenerRating(LocalListener localListener) {
		localListenerRepository.save(localListener);
	}
}
