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
public class listenerController {
    
    @GetMapping("/start")
    public String home() {
        return "startpage";
    }
    
    @GetMapping("/listenerlogin")
    public String listenerLogin() {
        
        return "listenerlogin";
    }
    
    @GetMapping("/listenerpage")
    public String listenerPage() {
        return "listenerPage";
    }
    

}
