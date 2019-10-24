package dev.tasacdws.services;

import dev.tasacdws.entities.Artist;

public interface ArtistService {

	
	//create
	Artist createArtist(Artist artist);
	
	//read
	Artist getArtistById(int id);
	Artist getArtistByUsername(String username);
	Artist getArtistByUsernameAndPassword(String username, String password);
	
	//update
	Artist updateArtist(Artist artist);
	
	//delete
	boolean deleteArtist(Artist artist);
	
}
