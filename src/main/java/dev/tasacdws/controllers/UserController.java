package dev.tasacdws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.tasacdws.entities.Users;
import dev.tasacdws.services.UserService;


@CrossOrigin(origins = "http://ec2-18-216-221-127.us-east-2.compute.amazonaws.com:9999")
@Component
@RestController
public class UserController{
	
	@Autowired
	UserService us;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Users createArtist(@RequestBody Users u) {
		u = us.createUser(u);
		return u;
	}
}
