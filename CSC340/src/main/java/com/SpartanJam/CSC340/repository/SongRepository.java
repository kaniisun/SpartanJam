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
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<ArtistSong, Long> 
{
    public List<ArtistSong> findByUploaderUsername(String username);    
    
    @Query("SELECT a FROM User a WHERE CONCAT(a.userName) LIKE %?1%")
    public List<ArtistSong> search(String key);

    public Optional<ArtistSong> findById(Integer id);
}
