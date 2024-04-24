/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpartanJam.CSC340.repository;


import org.springframework.data.repository.CrudRepository;

import com.SpartanJam.CSC340.model.Admin;

/**
 *
 * @author sreyk
 */
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    
}

