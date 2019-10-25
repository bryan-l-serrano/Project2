package dev.tasacdws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.tasacdws.entities.Artist;
import dev.tasacdws.services.ArtistService;

@CrossOrigin(origins = "*")
@Component
@RestController
public class ArtistController {
	
	@Autowired
	ArtistService as;
	
	@RequestMapping(value = "/artist", method = RequestMethod.POST)
	public Artist createArtist(@RequestBody Artist artist) {
		artist = as.createArtist(artist);
		return artist;
	}
}
