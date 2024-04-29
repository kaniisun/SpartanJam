/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.SpartanJam.CSC340.model.Admin;
import com.SpartanJam.CSC340.model.ArtistSong;
import com.SpartanJam.CSC340.model.User;
import com.SpartanJam.CSC340.service.AdminService;
import com.SpartanJam.CSC340.service.ArtistService;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    ArtistService artistService;

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
    public String getUsers(Model model, @Param("key") String key) {
        model.addAttribute("listUsers", userService.getAllUsers(key));
        model.addAttribute("key", key);
        return "admin/editUsers";
    }

    @GetMapping("/approve")
    public String approve(Model model) {
        List<ArtistSong> artistSongs = artistService.listAll();
        model.addAttribute("artistSongs", artistSongs);
        return "admin/approve";
    }

    @GetMapping("/songSearch")
    public String getSongs(Model model, @Param("key") String key) {
        model.addAttribute("artistSongs", userService.getAllUsers(key));
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

    /*    @GetMapping("/deny/{id}")
    public String deny(@PathVariable("id") Long id) {
        artistService.delete(id);
        return "redirect:/admin/approve";
    }*/
    @GetMapping("/approve/{id}")
    public String approve(@PathVariable("id") Long id) {
        ArtistSong song = artistService.get(id);
        song.setApproved(true);
        artistService.save(song);
        return "redirect:/admin/approve";
    }

    @GetMapping("/deny/{id}")
    public String deny(@PathVariable("id") Long id, @RequestParam(value = "comment", required = false) String comment) {
        ArtistSong song = artistService.get(id);
        song.setApproved(false);
        song.setDenial(comment);
        artistService.save(song);
        return "redirect:/admin/approve";
    }
}
