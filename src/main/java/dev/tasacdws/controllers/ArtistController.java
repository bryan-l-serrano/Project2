package dev.tasacdws.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.tasacdws.entities.Artist;
import dev.tasacdws.services.ArtistService;

@CrossOrigin(origins = "http://ec2-18-216-221-127.us-east-2.compute.amazonaws.com:9999")
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
	
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	public Artist getArtistById(@PathVariable int id) {
		Artist art = as.getArtistById(id);
		return art;
	}
	
	@RequestMapping(value = "/artist", method = RequestMethod.GET)
	public List<Artist> getAllArtists() {
		List<Artist> artists = as.getAllArtists();
		return artists;
	}
	
	


	@RequestMapping(value = "/artist/login", method = RequestMethod.POST)

    public Artist artistLogin(@RequestBody Artist response, HttpSession session) {

        Artist art = as.getArtistByUsername(response.getUsername());

        if(art.getPassword().equals(response.getPassword())) {

            art.setPassword("");

            session.setAttribute("Artist", art);

        return art;

        }

        else {

            return null;

        }
    }
	
	


	
}
