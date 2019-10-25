package dev.tasacdws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.tasacdws.entities.Artist;


@Component
@Repository
public interface ArtistRepository extends CrudRepository<Artist,Integer> {
	Artist findByUsername(String username);
	
}