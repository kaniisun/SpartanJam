/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.controller;


import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpartanJam.CSC340.model.ArtistSong;
import com.SpartanJam.CSC340.model.Listener;
import com.SpartanJam.CSC340.model.LocalListener;
import com.SpartanJam.CSC340.model.Song;
import com.SpartanJam.CSC340.service.ListenerService;
import com.SpartanJam.CSC340.service.LocalListenerService;
import com.SpartanJam.CSC340.service.SongService;
import com.SpartanJam.CSC340.service.SpotifyExternalService;

/**
 *
 * @author sreyk
 */
@Controller
@RequestMapping("/listener")
public class ListenerController {
	
	@Autowired
	ListenerService listenerService;
	
	@Autowired
	LocalListenerService localListenerService;
	
	@Autowired
	SongService songService;
	
	SpotifyExternalService spotifyExternalService = new SpotifyExternalService();
	
	
	@GetMapping("/home")
	public String home(Model model) {
		System.out.println("Listener home page");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Listener listener = new Listener();
		listener.setUsername(name);
        model.addAttribute("listener",listener);
        
		List<Song> songs = spotifyExternalService.getSpotifyTracks();
		model.addAttribute("songs", songs);
		return "listener/listener";
	}
	
	@GetMapping("/localLibrary")
	public String localSongsAddedByArtist(Model model) {
		System.out.println("Local Listener library page");
		List<ArtistSong> listOfSongs = songService.getAllArtistSongs();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
		LocalListener localListener = new LocalListener();
		localListener.setUsername(name);
        model.addAttribute("localListener",localListener);
        
		model.addAttribute("songs", listOfSongs);
		
		return "listener/local-songs";
	}
	
	@GetMapping("/favorites")
	public String library(Model model) {
		System.out.println("Library page");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Listener> listeners = listenerService.getAllListenersByUsername(name);
        model.addAttribute("listeners",listeners);
        
		return "listener/favorites";
	}
	
	@GetMapping("/localFavorites")
	public String localFavorites(Model model) {
		System.out.println("Local Favorites page");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<LocalListener> localListeners = localListenerService.getAllLocalListenersByUsername(name);
        model.addAttribute("localListeners",localListeners);
        
		return "listener/local-favorites";
	}
	
	@PostMapping("/addFavSong")
	public String addFavSong(Listener listener) {
		System.out.println("Add new Favorite songs");
		System.out.println(listener.toString());
		listenerService.addFavSong(listener);
		return "redirect:/listener/favorites";
	}
	
	@PostMapping("/addLocFavSong")
	public String addLocFavSong(LocalListener localListener) {
		System.out.println("Add new Local Favorite songs");
		System.out.println(localListener.toString());
		localListenerService.addLocFavSong(localListener);
		return "redirect:/listener/localFavorites";
	}
	
	@GetMapping("/increaseRating/listenerId={id}")
	public String increaseRating(@PathVariable int id) {
		System.out.println("Increase rating for id = " + id);
        Listener listener = listenerService.getListenerById(id);
        listener.setRating('P');
        listenerService.updateListenerRating(listener);
		return "redirect:/listener/favorites";
	}
	
	@GetMapping("/increaseLocalListenerRating/listenerId={id}")
	public String increaseLocalListenerRating(@PathVariable int id) {
		System.out.println("Increase Local Listener rating for id = " + id);
        LocalListener localListener = localListenerService.getLocListenerById(id);
        localListener.setRating('P');
        localListenerService.updateLocalListenerRating(localListener);
		return "redirect:/listener/localFavorites";
	}
	
	@GetMapping("/decreaseRating/listenerId={id}")
	public String decreaseRating(@PathVariable int id) {
		System.out.println("Decrease rating for id = " + id);
        Listener listener = listenerService.getListenerById(id);
        listener.setRating('N');
        listenerService.updateListenerRating(listener);
		return "redirect:/listener/favorites";
	}
	
	@GetMapping("/decreaseLocalListenerRating/listenerId={id}")
	public String decreaseLocalListenerRating(@PathVariable int id) {
		System.out.println("Decrease Local Listener rating for id = " + id);
        LocalListener localListener = localListenerService.getLocListenerById(id);
        localListener.setRating('N');
        localListenerService.updateLocalListenerRating(localListener);
		return "redirect:/listener/localFavorites";
	}
	
	@GetMapping("/deleteFavSong/listenerId={id}")
	public String deleteFavSong(@PathVariable int id) {
		System.out.println("Delete favorite song with id = " + id);
		listenerService.removeFavSong(id);
		return "redirect:/listener/favorites";
	}
	
	@GetMapping("/deleteLocalFavSong/listenerId={id}")
	public String deleteLocalFavSong(@PathVariable int id) {
		System.out.println("Delete Local favorite song with id = " + id);
		localListenerService.removeLocFavSong(id);
		return "redirect:/listener/localFavorites";
	}
}
