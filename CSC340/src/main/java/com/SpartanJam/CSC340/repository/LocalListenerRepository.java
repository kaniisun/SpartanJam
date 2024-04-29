package com.SpartanJam.CSC340.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.SpartanJam.CSC340.model.LocalListener;

/**
*
* @author NehaChauhan
*/
public interface LocalListenerRepository extends CrudRepository<LocalListener, Integer> {
	
	Optional<List<LocalListener>> getAllLocalListenersByUsername(String username);
	
	Optional<LocalListener> findLocalListenerByUsernameAndTitle(String username, String title);

}
