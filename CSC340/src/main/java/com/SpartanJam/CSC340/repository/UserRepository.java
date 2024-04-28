/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpartanJam.CSC340.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.SpartanJam.CSC340.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author sreyk
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String username);

    @Query("SELECT a FROM User a WHERE CONCAT(a.userName) LIKE %?1%")
    public List<User> search(String key);
}
