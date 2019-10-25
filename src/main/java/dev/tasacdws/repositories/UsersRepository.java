package dev.tasacdws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.tasacdws.entities.Artist;
import dev.tasacdws.entities.Users;

@Component
@Repository
public interface UsersRepository extends CrudRepository<Users,Integer>{
	Users findByUsername(String username);
	

}
