/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.listener;


import com.SpartanJam.CSC340.listener.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreyk
 */
@Service
public class AdminService {
    @Autowired 
    private AdminRepository repo;
    
    public List<admin> listAll() {
        return (List<admin>) repo.findAll();
    }
}
