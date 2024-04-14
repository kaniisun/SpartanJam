/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.listener;


import java.util.ArrayList;
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
    // Fetch real users from the service
    List<admin> realUsers = service.listAll();
    
    // Create fake users
    List<admin> fakeUsers = new ArrayList<>();
    fakeUsers.add(new admin(1, "John"));
    fakeUsers.add(new admin(2, "Alice"));
    fakeUsers.add(new admin(3, "Bob"));
    
    // Merge real and fake users
    List<admin> allUsers = new ArrayList<>();
    allUsers.addAll(realUsers);
    allUsers.addAll(fakeUsers);
    
    // Add the merged list to the model
    model.addAttribute("listUsers", allUsers);
    
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
