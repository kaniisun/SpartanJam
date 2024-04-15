/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.controller;


import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpartanJam.CSC340.model.Admin;
import com.SpartanJam.CSC340.service.AdminService;

/**
 *
 * @author sreyk
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;
    
//    @GetMapping("/adminlogin")
//    public String adminLogin() {
//        
//        return "adminlogin";
//    }
//    
//    @GetMapping("/adminpage")
//    public String adminPage(Model model) {
//        List<Admin> listUsers = service.listAll();
//        model.addAttribute("listUsers", listUsers);
//        return "admin";
//    }
//    
//    @GetMapping("/approve")
//    public String approve() {
//        return "approve";
//    }
//    
//    @GetMapping("/edit")
//    public String editUsers(Model model) {
//        return "editUsers";
//    }
//    
//    @GetMapping("/editUser")
//    public String editUser() {
//        return "adminEdit";
//    }

}
