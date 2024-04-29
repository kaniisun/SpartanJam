/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpartanJam.CSC340.service;

import com.SpartanJam.CSC340.model.ArtistSong;
import com.SpartanJam.CSC340.repository.SongRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sreyk
 */
@Service
public class ArtistService {

    @Autowired
    private SongRepository repo;

    public List<ArtistSong> listAll() {
        return (List<ArtistSong>) repo.findAll();
    }

    public ArtistSong get(Long id) {
        Optional<ArtistSong> result = repo.findById(id);
        return result.get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }    
}
