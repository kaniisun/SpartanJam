package com.SpartanJam.CSC340.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.SpartanJam.CSC340.model.Listener;

/**
*
* @author NehaChauhan
*/
public interface ListenerRepository extends CrudRepository<Listener, String> {
	
	Optional<List<Listener>> getAllListenersByUsername(String username);
	
	Optional<Listener> findListernerByUsernameAndSongName(String username, String songName);
}
