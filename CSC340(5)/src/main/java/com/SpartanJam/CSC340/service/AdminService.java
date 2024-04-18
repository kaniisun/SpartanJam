/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpartanJam.CSC340.model.Admin;
import com.SpartanJam.CSC340.repository.AdminRepository;

/**
 *
 * @author sreyk
 */
@Service
public class AdminService {
    @Autowired 
    private AdminRepository repo;
    
    public List<Admin> listAll() {
        return (List<Admin>) repo.findAll();
    }
    
    
}
