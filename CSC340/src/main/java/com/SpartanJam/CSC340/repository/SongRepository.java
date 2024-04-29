
package com.SpartanJam.CSC340.repository;

/**
 *
 * @author sebas
 */


import com.SpartanJam.CSC340.model.ArtistSong;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<ArtistSong, Long> 
{

    public List<ArtistSong> findByUploaderUsername(String username);

}
