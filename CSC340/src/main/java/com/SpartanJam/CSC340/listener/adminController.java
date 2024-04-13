/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.listener;


import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author sreyk
 */
@Controller
public class adminController {
    @Autowired
    private AdminService service;
    
    @GetMapping("/adminlogin")
    public String adminLogin() {
        
        return "adminlogin";
    }
    
    @GetMapping("/adminpage")
    public String adminPage(Model model) {
        List<admin> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "admin";
    }
    
    @GetMapping("/approve")
    public String approve() {
        return "approve";
    }
    
    @GetMapping("/edit")
    public String editUsers(Model model) {
        return "editUsers";
    }
    
    @GetMapping("/editUser")
    public String editUser() {
        return "adminEdit";
    }

}
