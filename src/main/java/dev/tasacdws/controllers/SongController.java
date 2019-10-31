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
	public Song createSong(@RequestBody TemporarySong song) {
		Song newSong = ss.createSong(song);
		return newSong;
		
	}
	
	//read
	@RequestMapping(value = "/song/{id}", method = RequestMethod.GET)
	public Song getSongById(@PathVariable int id) {
		Song song = ss.getSongById(id);
		return song;
		
	}
	
	@RequestMapping(value = "/song", method = RequestMethod.GET)
	public Set<Song> getAllSongs() {
		Set<Song> songs = ss.getAllSongs();
		return songs;
		
	}
	
	@RequestMapping(value = "/song/artist/{id}", method = RequestMethod.GET)
	public Set<Song> getAllSongsByArtistId(@PathVariable int id){
		Set<Song> songs = ss.getAllSongsByArtistId(id);
		return songs;
		
	}
	
	@RequestMapping(value = "/song/name/{name}", method = RequestMethod.GET)
	public Set<Song> getSongsByName(@PathVariable String name){
		Set<Song> songs = ss.getAllSongsByName(name);
		return songs;
	}
	
	//update
	@RequestMapping(value = "/song", method = RequestMethod.PUT)
	public Song updateSong(@RequestBody Song song) {
		Song change = this.ss.getSongById(song.getId());
		change.setAlbumName(song.getAlbumName());
		change.setArtist(song.getArtist());
		change.setComments(song.getComments());
		change.setInAlbum(song.getInAlbum());
		change.setLink(song.getLink());
		change.setName(song.getName());
		change.setRating(song.getRating());
		change.setReleaseDate(song.getReleaseDate());
		
		this.ss.updateSong(change);
		return change;
		
	}
	
	//delete
	@RequestMapping(value = "/song", method = RequestMethod.DELETE)
	public boolean deleteSong(@RequestBody Song song) {
		
		boolean result = ss.deleteSong(song);
		return result;
		
	}

}
