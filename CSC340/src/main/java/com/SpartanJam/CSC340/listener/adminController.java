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
public class adminController {
    
    @GetMapping("/adminlogin")
    public String adminLogin() {
        return "adminlogin";
    }
    
    @GetMapping("/adminpage")
    public String adminPage() {
        return "admin";
    }
    
    @GetMapping("/approve")
    public String approve() {
        return "approve";
    }
    
    @GetMapping("/edit")
    public String editUsers() {
        return "editUsers";
    }

}
