package com.SpartanJam.CSC340.controller;

import com.SpartanJam.CSC340.model.Song;
import com.SpartanJam.CSC340.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongUploadController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/song/{id}")
    public String viewSong(@PathVariable Long id, Model model) {
        // Retrieve song details from the database
        Song song = songRepository.findById(id).orElse(null);
        if (song == null) {
            // Handle song not found
            return "error"; // You need to create an error.html template
        }
        // Pass song details to the Thymeleaf template
        model.addAttribute("song", song);
        return "song";
    }
}