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
public class forumController {
    
    @GetMapping("/forumlogin")
    public String forumLogin(){
        return "forumlogin";
    }
    
    @GetMapping("/forumpage")
    public String adminPage() {
        return "forum";
    }
    
        
    @GetMapping("/forum")
    public String forum(){
        return "forumpage";
    }
}
