package dev.tasacdws.services;

import dev.tasacdws.entities.Artist;
import dev.tasacdws.entities.Users;

public interface UserService {
	
	//create
		Users createUser(Users user);
		
		//read
		Users getUserById(int id);
		Users getUserByUsername(String username);
		Users getUserByUsernameAndPassword(String username, String password);
		
		//update
		Users updateUser(Users user);
		
		//delete
		boolean deleteUser(Users user);
	

}
