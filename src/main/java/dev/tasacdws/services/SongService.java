package dev.tasacdws.services;

import java.util.Set;

import dev.tasacdws.entities.Song;
import dev.tasacdws.entities.TemporarySong;

public interface SongService {
	
	// Create
	TemporarySong createSong(TemporarySong song);
	
	// Read
	//TemporarySong getTemporarySongById(int id);
	Song getSongById(int id);
	Set<TemporarySong> getAllSongs();
	Set<TemporarySong> getAllSongsByArtistId(int id);
	Set<TemporarySong> getAllSongsByName(String name);
	Set<TemporarySong> getAllSongsByArtistName(String name);
	
	// Update
	TemporarySong updateSong(TemporarySong song);
	
	// Delete
	boolean deleteSong(Song song);

}
