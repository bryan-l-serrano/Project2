package dev.tasacdws.repositories;

import org.springframework.data.repository.CrudRepository;

import dev.tasacdws.entities.Artist;
import dev.tasacdws.entities.Users;



public interface ArtistRepository extends CrudRepository<Artist,Integer> {
	
}
