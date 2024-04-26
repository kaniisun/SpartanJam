package com.SpartanJam.CSC340.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    
    @GetMapping("/artistlogin")
    public String listenerLogin() {
        return "artistlogin";
    }
    
    @GetMapping("/artistpage")
    public String artistPage() {
        return "artist";
    }
        
    @GetMapping("/artistedit")
    public String artistEdit() {
        return "artist/artistedit";
    }
    
    @GetMapping("/artistupload")
    public String artistUpload() {
        return "artist/artistupload";
    }
}