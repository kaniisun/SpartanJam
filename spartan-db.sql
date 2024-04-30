-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2024 at 04:17 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spartan-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `artist_song`
--

CREATE TABLE `artist_song` (
  `id` bigint(20) NOT NULL,
  `approved` bit(1) NOT NULL,
  `audio_file_path` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `uploader_username` varchar(255) DEFAULT NULL,
  `denied` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artist_song`
--

INSERT INTO `artist_song` (`id`, `approved`, `audio_file_path`, `description`, `title`, `uploader_username`, `denied`, `comment`) VALUES
(3, b'1', '/audio/9059e799-a86f-4b6f-84cf-031ecec8ab27-testsong.mp3', 'thumbs up', 'song', 'artist', NULL, NULL),
(4, b'1', '/audio/4822ca7b-3afd-4e58-a33e-64c94fd24975-testsong.mp3', '', 'my song', 'artist', NULL, NULL),
(5, b'1', '/audio/2d8d882d-0aa8-488a-bce4-a0a2fb1c693b-testsong.mp3', '', 'teest', 'artist', NULL, NULL),
(6, b'1', '/audio/1d2bdf20-82e1-47bc-bcb2-735bd161a4a7-testsong.mp3', '', 'TEST', 'artist', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `listener`
--

CREATE TABLE `listener` (
  `id` int(11) NOT NULL,
  `songname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `album_name` varchar(255) NOT NULL,
  `artist_name` varchar(255) NOT NULL,
  `rating` char(1) DEFAULT NULL,
  `song_name` varchar(255) NOT NULL,
  `spotify_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `listener`
--

INSERT INTO `listener` (`id`, `songname`, `username`, `album_name`, `artist_name`, `rating`, `song_name`, `spotify_url`) VALUES
(2, NULL, 'listener', 'The Papercut Chronicles II', 'Gym Class Heroes', NULL, 'Stereo Hearts (feat. Adam Levine)', 'https://open.spotify.com/track/0qOnSQQF0yzuPWsXrQ9paz');

-- --------------------------------------------------------

--
-- Table structure for table `local_listener`
--

CREATE TABLE `local_listener` (
  `id` int(11) NOT NULL,
  `artist_name` varchar(255) DEFAULT NULL,
  `audio_file_path` varchar(255) NOT NULL,
  `rating` char(1) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `local_listener`
--

INSERT INTO `local_listener` (`id`, `artist_name`, `audio_file_path`, `rating`, `title`, `username`) VALUES
(1, 'artist', '/audio/9059e799-a86f-4b6f-84cf-031ecec8ab27-testsong.mp3', NULL, 'song', 'ksun'),
(2, 'artist', '/audio/4822ca7b-3afd-4e58-a33e-64c94fd24975-testsong.mp3', NULL, 'my song', 'ksun');

-- --------------------------------------------------------

--
-- Table structure for table `song`
--

CREATE TABLE `song` (
  `id` bigint(20) NOT NULL,
  `approved` bit(1) NOT NULL,
  `audio_file_path` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `uploader_username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `role`, `user_name`) VALUES
(1, 'user@domain.com', '$2a$10$sLhMbRsIouUgGWPLJ1z80e1rxPYowmRB4rnz6w669XyONYmumEp3i', 'ADMIN', 'ksun'),
(4, 'forum@domain.com', '$2a$10$kZHijlSDw5qgwJCTCV7SjuljxO5t0GmDgOyCRIiifpFkIyoLOfTwa', 'FORUM', 'forum'),
(6, 'listener@domain.com', '$2a$10$SwuW1DLJyJhIWneOiahXo.KkHniZgSeh3xYfCl2oALJ8JrQp6F7Gu', 'LISTENER', 'listener'),
(7, 'artist@domain.com', '$2a$10$vcmyswjvNJNna0ijaYY2euF.kon865jAQ1TAJM32J3kgmVIQRX7Li', 'ARTIST', 'artist');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(15) NOT NULL,
  `user_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist_song`
--
ALTER TABLE `artist_song`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `listener`
--
ALTER TABLE `listener`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `local_listener`
--
ALTER TABLE `local_listener`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artist_song`
--
ALTER TABLE `artist_song`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `listener`
--
ALTER TABLE `listener`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `local_listener`
--
ALTER TABLE `local_listener`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `song`
--
ALTER TABLE `song`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
