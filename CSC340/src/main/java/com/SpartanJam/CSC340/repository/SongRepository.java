/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpartanJam.CSC340.repository;

/**
 *
 * @author sebas
 */


import com.SpartanJam.CSC340.model.ArtistSong;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<ArtistSong, Long> 
{

}
