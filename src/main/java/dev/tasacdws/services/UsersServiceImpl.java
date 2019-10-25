package dev.tasacdws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.tasacdws.entities.Users;
import dev.tasacdws.repositories.UsersRepository;

@Component
@Service
public class UsersServiceImpl implements UserService{
	
	@Autowired
	UsersRepository ur;
	

	@Override
	public Users createUser(Users user) {
		user = ur.save(user);
		return user;
	}

	@Override
	public Users getUserById(int id) {
		Users user = ur.findById(id).get();
		return user;
	}

	@Override
	public Users getUserByUsername(String username) {
		Users user = ur.findByUsername(username);
		return user;
	}

//	@Override
//	public Users getUserByUsernameAndPassword(String username, String password) {
//		Users user = ur.findByUsername(username);
//		if(user.getPassword().equals(password)) {
//			return user;
//		}else {
//			return null;
//		}
//	}

	@Override
	public Users updateUser(Users user) {
		user = ur.save(user);
		return user;
	}

	@Override
	public boolean deleteUser(Users user) {
		try {
			ur.delete(user);
			return true;
		}catch(IllegalArgumentException e) {
			return false;
		}
	}

}
