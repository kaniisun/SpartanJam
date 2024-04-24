package com.SpartanJam.CSC340.controller;

import com.SpartanJam.CSC340.model.ArtistSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import com.SpartanJam.CSC340.repository.SongRepository;

@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Value("${upload.path}")
    private String uploadPath;

    // Maximum file size limit in bytes (1GB)
    private static final long MAX_FILE_SIZE_LIMIT = 1073741824;

    @PostMapping("/home")
    public String submitSong(@RequestParam("title") String title, 
                             @RequestParam("description") String description, 
                             @RequestParam("audio") MultipartFile audioFile, 
                             Authentication authentication) {

        try {
            String uploaderUsername = authentication.getName();
            if (audioFile.isEmpty()) {
                return "redirect:/home"; // Handle empty audio file
            }

            // Check if the file size exceeds the maximum limit
            if (audioFile.getSize() > MAX_FILE_SIZE_LIMIT) {
                // Handle file size exceeded error
                return "redirect:/home";
            }

            String fileName = UUID.randomUUID().toString() + "-" + audioFile.getOriginalFilename();
            String sanitizedFileName = fileName.replaceAll("\\s+", "_");

            // Construct the audio file path
            String audioFilePath = "/audio/" + sanitizedFileName;

            // Ensure directory exists
            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Save the file to the upload directory
            Path destination = uploadDir.resolve(sanitizedFileName);
            Files.write(destination, audioFile.getBytes());

            // Create Song object and set attributes
            ArtistSong song = new ArtistSong();
            song.setTitle(title);
            song.setDescription(description);
            song.setAudioFilePath(audioFilePath);
            song.setUploaderUsername(uploaderUsername);
            song.setApproved(false);

            // Save the song to the database
            songRepository.save(song); 

            // Redirect to the homepage after successful upload
            return "redirect:/home"; 
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/home"; // Redirect to error page if an exception occurs
        }
    }
}