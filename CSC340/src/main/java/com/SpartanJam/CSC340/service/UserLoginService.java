package com.SpartanJam.CSC340.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpartanJam.CSC340.model.User;
import com.SpartanJam.CSC340.repository.UserRepository;

/**
*
* @author NehaChauhan
*/
@Service
public class UserLoginService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        User user = userRepository.findByUserName(username).orElseThrow(()
                -> new UsernameNotFoundException(username + "not found"));
        ArrayList<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), authList);
	}

}
