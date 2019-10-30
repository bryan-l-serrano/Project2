package dev.tasacdws.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.tasacdws.entities.Song;

@Component
@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {
	Set<Song> findAllByName(String name);


}
