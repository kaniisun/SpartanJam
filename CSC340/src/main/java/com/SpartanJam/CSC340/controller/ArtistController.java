/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sreyk
 */
@Controller
public class ArtistController {
    
    @GetMapping("/artistlogin")
    public String listenerLogin() {
        
        return "artistlogin";
    }
    
    @GetMapping("/artistpage")
    public String artistPage() {
        
        return "artist";
    }
        
    @GetMapping("artist/artistedit")
    public String artistEdit() {

        return "artistedit";
    }
    
    @GetMapping("artist/artistupload")
    public String artistUpload() {
        
        return "artistupload";
    }
    
}
