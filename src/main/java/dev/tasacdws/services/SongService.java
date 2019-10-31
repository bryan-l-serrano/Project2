package dev.tasacdws.services;

import java.util.Set;

import dev.tasacdws.entities.Song;
import dev.tasacdws.entities.TemporarySong;

public interface SongService {
	
	// Create
	Song createSong(TemporarySong song);
	
	// Read
	Song getSongById(int id);
	Set<Song> getAllSongs();
	Set<Song> getAllSongsByArtistId(int id);
	Set<Song> getAllSongsByName(String name);
	
	// Update
	Song updateSong(Song song);
	
	// Delete
	boolean deleteSong(Song song);

}
