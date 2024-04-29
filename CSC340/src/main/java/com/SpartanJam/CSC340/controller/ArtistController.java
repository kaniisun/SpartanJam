package com.SpartanJam.CSC340.controller;

import com.SpartanJam.CSC340.model.ArtistSong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

import com.SpartanJam.CSC340.repository.SongRepository; // Assuming the package location is correct
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private SongRepository songRepository;
    
    @GetMapping("/home")
    public String home() {
    	System.out.println("Artist home page");
    	return "artist/artist";
    }

    @GetMapping("/artistlogin")
    public String listenerLogin() {
        return "artistlogin";
    }

    @GetMapping("/artistpage")
    public String artistPage(Model model, Authentication authentication) {
        System.out.println("artistPage is nowo running");
        String username = authentication.getName();
        System.out.println("Username: " + username);
        List<ArtistSong> songs = songRepository.findByUploaderUsername(username); // Assuming this method exists
        System.out.println("Number of songs retrieved: " + songs.size());
        model.addAttribute("songs", songs);
        return "artist";
    }

    @GetMapping("/artistupload")
    public String artistUpload() {
        return "artist/artistupload";
    }

    @GetMapping("/artisedit")
    public String artistEdit() {
        return "artist/artisedit";
    }
}