package com.SpartanJam.CSC340.controller;

import com.SpartanJam.CSC340.model.Song;
import com.SpartanJam.CSC340.repository.SongRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sebastian Del Campo
 * CSC 340 - SpartanJam Artist Use Case: SongController
 * 
 * CRUD Application that will gather information input from artistupload.html,
 * all data will be saved in spartan_db under the song table
 * @since April 17, 2024
 */

@Controller
public class SongController 
{
    //Private data
    @Autowired
    private SongRepository songRepository;

    @Value("${upload.path}")
    private String uploadPath;

    //Main function for processing music upload
    @PostMapping("/home")
    public String submitSong(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("audio") MultipartFile audioFile, Authentication authentication) 
    {
        try 
        {
            String uploaderUsername = authentication.getName();
            if (audioFile.isEmpty()) 
            {
                return "redirect:/home"; // Handle empty audio file
            }

            String fileName = UUID.randomUUID().toString() + "-" + audioFile.getOriginalFilename();
            
            // Fixing file path to replace spaces with underscores
            String sanitizedFileName = fileName.replaceAll("\\s+", "_");
            String filePath = uploadPath + File.separator + sanitizedFileName;

            // Ensure directory exists to ensure file is there
            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) 
            {
                Files.createDirectories(uploadDir);
            }

            //Grabs the file of from where it was uploaded and then implemented into the audio folder
            Path destination = uploadDir.resolve(sanitizedFileName);
            Files.write(destination, audioFile.getBytes());
            
            
            // Creates Song Dataset to store
            Song song = new Song();
            song.setTitle(title);
            song.setDescription(description);
            song.setAudioFilePath(filePath);
            song.setUploaderUsername(uploaderUsername);
            song.setApproved(false);

            //Save song data to the database
            songRepository.save(song); 

            //Redirect to the homepage after successful upload
            return "redirect:/home"; 
        } 
        catch (IOException e) //Redirect to error page if an exception occurs
        {
            e.printStackTrace();
            return "redirect:/home"; 
        }
    }
}