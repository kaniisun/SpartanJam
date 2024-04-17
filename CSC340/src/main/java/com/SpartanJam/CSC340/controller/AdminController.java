/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.controller;



import org.springframework.web.bind.annotation.RequestMapping;

import com.SpartanJam.CSC340.model.Admin;
import com.SpartanJam.CSC340.model.User;
import com.SpartanJam.CSC340.service.AdminService;
import com.SpartanJam.CSC340.service.UserService;
import java.util.ArrayList;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sreyk
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;
    
    	@Autowired
	UserService userService;
    
    @GetMapping("/adminlogin")
    public String adminLogin() {
        
        return "adminlogin";
    }
    
@GetMapping("/adminpage")
public String adminPage(Model model) {
    // Fetch real users from the service
    List<Admin> realUsers = service.listAll();
    
    // Create fake users
    List<Admin> fakeUsers = new ArrayList<>();
    fakeUsers.add(new Admin(1, "John"));
    fakeUsers.add(new Admin(2, "Alice"));
    fakeUsers.add(new Admin(3, "Bob"));
    
    // Merge real and fake users
    List<Admin> allUsers = new ArrayList<>();
    allUsers.addAll(realUsers);
    allUsers.addAll(fakeUsers);
    
    // Add the merged list to the model
    model.addAttribute("listUsers", allUsers);
    
    return "admin/admin";
}
    
    @GetMapping("/approve")
    public String approve() {
        return "admin/approve";
    }
    
    @GetMapping("/edit")
    public String editUsers(Model model) {
    // Fetch all users from the service, including newly created ones
    List<User> allUsers = userService.getAllUsers();
    
    // Add the list of users to the model
    model.addAttribute("listUsers", allUsers);
        return "admin/editUsers";
    }
    
    @GetMapping("/editUser")
    public String editUser() {
        return "admin/adminEdit";
    }
    
    @GetMapping("/editUser/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "admin/adminEdit";
    }    
    
    @PostMapping("/editUser/update")
    public String updateUser(User user) {
    userService.save(user);
        return "redirect:/admin/edit";
}    

}


