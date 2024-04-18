/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpartanJam.CSC340.model.User;
import com.SpartanJam.CSC340.repository.UserRepository;
import java.util.Optional;

/**
 *
 * @author sreyk
 */
@Service
public class UserService {
    @Autowired 
    private UserRepository repo;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
    
    public boolean saveUser(User user) {
    	//Check if username already exists in database
    	for(User tempUser: this.listAll()) {
    		if(tempUser.getUserName().equals(user.getUserName())) {
    			System.out.println("Username: " + tempUser.getUserName() + " already exists in database.");
    			return false;
    		}
    	}
    	//Encrypt password before saving in database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        repo.save(user);
        
    	System.out.println("New User created: " + user.toString());
    	return true;
    }
    
    public String getUserRole(String username) {
       User user = repo.findByUserName(username).orElseThrow(()
                -> new UsernameNotFoundException(username + "not found"));
       return user.getRole();
    }
    
        public List<User> getAllUsers() {
        return (List<User>) repo.findAll();
    }
        
    public User get(Integer id) {
        Optional<User> result = repo.findById(id);
        return result.get();
    }   
    
    public void save(User user) {
        repo.save(user);
    }    
    
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    public List<User> getAllProducts(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
}
