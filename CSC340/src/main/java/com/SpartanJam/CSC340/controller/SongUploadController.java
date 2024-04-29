package com.SpartanJam.CSC340.controller;

import com.SpartanJam.CSC340.model.ArtistSong;
import com.SpartanJam.CSC340.repository.SongRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongUploadController {

    @Autowired
    private SongRepository songRepository;

    // View a specific song
    @GetMapping("/song/{id}")
    public String viewSong(@PathVariable Long id, Model model, HttpServletRequest request) {
        ArtistSong song = songRepository.findById(id).orElse(null);
        if (song == null) {
            return "error";
        }
        model.addAttribute("song", song);
        
        // Generate the shareable URL
        String currentUrl = request.getRequestURL().toString();
        model.addAttribute("shareUrl", currentUrl);
        
        return "artist/song";
    }
}
