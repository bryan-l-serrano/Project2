package dev.tasacdws.services;

import java.util.List;

import dev.tasacdws.entities.Artist;

public interface ArtistService {

	
	//create
	Artist createArtist(Artist artist);
	
	//read
	Artist getArtistById(int id);
	Artist getArtistByUsername(String username);
	List<Artist> getAllArtists();
	//Artist getArtistByUsernameAndPassword(String username, String password);
	
	//update
	Artist updateArtist(Artist artist);
	
	//delete
	boolean deleteArtist(Artist artist);
	
}
