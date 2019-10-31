package dev.tasacdws.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.tasacdws.entities.Song;
import dev.tasacdws.entities.TemporarySong;
import dev.tasacdws.repositories.SongRepository;
import dev.tasacdws.repositories.UsersRepository;
import dev.tasacdws.services.SongService;

@CrossOrigin(origins = "*")
@Component
@RestController
public class SongController {
	
	@Autowired
	SongService ss;
	
	//create
	@RequestMapping(value = "/song", method = RequestMethod.POST)
	public TemporarySong createSong(@RequestBody TemporarySong song) {
		song = ss.createSong(song);
		return song;
	}
	
	//read
	@RequestMapping(value = "/song/{id}", method = RequestMethod.GET)
	public TemporarySong getSongById(@PathVariable int id) {
		Song s = ss.getSongById(id);
		TemporarySong newSong = new TemporarySong();
		newSong.setId(s.getId());
		newSong.setArtistId(s.getArtist().getId());
		newSong.setName(s.getName());
		newSong.setReleaseDate(s.getReleaseDate());
		newSong.setAlbumName(s.getAlbumName());
		newSong.setInAlbum(s.getInAlbum());
		newSong.setRating(s.getRating());
		newSong.setLink(s.getLink());
		newSong.setAlbumArt(s.getAlbumArt());
		return newSong;
		
	}
	
	@RequestMapping(value = "/song", method = RequestMethod.GET)
	public Set<TemporarySong> getAllSongs() {
		Set<TemporarySong> songs = ss.getAllSongs();
		return songs;
		
	}
	
	@RequestMapping(value = "/song/artist/{id}", method = RequestMethod.GET)
	public Set<TemporarySong> getAllSongsByArtistId(@PathVariable int id){
		Set<TemporarySong> songs = ss.getAllSongsByArtistId(id);
		return songs;
		
	}
	
	@RequestMapping(value = "/song/name/{name}", method = RequestMethod.GET)
	public Set<TemporarySong> getSongsByName(@PathVariable String name){
		Set<TemporarySong> songs = ss.getAllSongsByName(name);
		return songs;
	}
	
	//update
	@RequestMapping(value = "/song", method = RequestMethod.PUT)
	public TemporarySong updateSong(@RequestBody TemporarySong song) {
		song = this.ss.updateSong(song);
		return song;
		
	}
	
	//delete
	@RequestMapping(value = "/song", method = RequestMethod.DELETE)
	public boolean deleteSong(@RequestBody Song song) {
		
		boolean result = ss.deleteSong(song);
		return result;
		
	}

}
