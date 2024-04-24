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
import org.springframework.data.repository.query.Param;
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

  /*@GetMapping("/adminlogin")
    public String adminLogin() {

        return "adminlogin";
    }

    @GetMapping("/adminpage")
    public String adminPage(Model model) {
    List<Admin> realUsers = service.listAll();
    model.addAttribute("listUsers", allUsers);
    
    return "admin/admin";
}*/
    
    @GetMapping("/approve")
    public String approve() {
        return "admin/approve";
    }

    @GetMapping("/edit")
    public String editUsers(Model model) {
        // get users
        List<User> allUsers = userService.getAllUsers();

        model.addAttribute("listUsers", allUsers);
        return "admin/editUsers";
    }

    // returns to edit page
    @GetMapping("/editUser")
    public String editUser() {
        return "admin/adminEdit";
    }

    // gets user form by user id
    @GetMapping("/editUser/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "admin/adminEdit";
    }

    // updates a user
    @PostMapping("/editUser/update")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/admin/edit";
    }

    // deletes a user
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/admin/edit";
    }

    // search for user
    @GetMapping("/search")
    public String getProducts(Model model, @Param("key") String key) {
        model.addAttribute("listUsers", userService.getAllUsers(key));
        model.addAttribute("key", key);
        return "admin/editUsers";
    }
   
    // user details
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "admin/adminDetails";
    }

}
