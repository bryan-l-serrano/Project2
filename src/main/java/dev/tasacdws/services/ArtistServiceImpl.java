package dev.tasacdws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import dev.tasacdws.entities.Artist;
import dev.tasacdws.repositories.ArtistRepository;

@Component
@Service
public class ArtistServiceImpl implements ArtistService{
	
	@Autowired
	ArtistRepository ar;

	@Override
	public Artist createArtist(Artist artist) {
		artist = ar.save(artist);
		return artist;
	}

	@Override
	public Artist getArtistById(int id) {
		Artist artist = ar.findById(id).get();
		return artist;
	}

	@Override
	public Artist getArtistByUsername(String username) {
		Artist artist = ar.findByUsername(username);
		return artist;
	}

	@Override
	public Artist getArtistByUsernameAndPassword(String username, String password) {
		Artist artist = ar.findByUsername(username);
		if(artist.getPassword().equals(password)) {
			return artist;
		}else {
			return null;
		}
		
	}

	@Override
	public Artist updateArtist(Artist artist) {
		artist = ar.save(artist);
		return artist;
	}

	@Override
	public boolean deleteArtist(Artist artist) {
		try {
			ar.delete(artist);
			return true;
		}catch(IllegalArgumentException e) {
			return false;
		}
	}

}
