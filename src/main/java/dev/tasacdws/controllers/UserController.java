package dev.tasacdws.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.tasacdws.entities.Users;
import dev.tasacdws.services.UserService;


@CrossOrigin(origins = "*")
@Component
@RestController
public class UserController{
	
	@Autowired
	UserService us;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Users createUser(@RequestBody Users u) {
		u = us.createUser(u);
		return u;
	}
	
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public Users getUserById(@PathVariable int id) {
		Users user = this.us.getUserById(id);
		return user;
	}
	
	@RequestMapping(value = "/user/username", method = RequestMethod.POST)
	public Users getUserByUsername(@RequestBody String username) {
		Users user = this.us.getUserByUsername(username);
		return user;
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public Users userLogin(@RequestBody Users response, HttpSession session) {
		Users user = us.getUserByUsername(response.getUsername());
	    if(user.getPassword().equals(response.getPassword())) {
            user.setPassword("");
            session.setAttribute("User", user);
        return user;
        }
        else {
            return null;
        }
        
		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public Users updateUser(@RequestBody Users user) {
		user = this.us.updateUser(user);
		return user;
		
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public boolean deleteUserById(@PathVariable int id) {
		boolean result = this.us.deleteUser(this.us.getUserById(id));
		return result;
		
	}
	
}
