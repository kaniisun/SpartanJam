/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.listener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author sreyk
 */
@Controller
public class artistController {
    
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
        
        return "artistedit";
    }
    
    @GetMapping("/artistupload")
    public String artistUpload() {
        
        return "artistupload";
    }
    
}
