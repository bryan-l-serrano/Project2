package dev.tasacdws.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Project2BackendApplication;

import dev.tasacdws.entities.Users;
import dev.tasacdws.services.UserService;

@SpringBootTest
//@Transactional
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = Project2BackendApplication.class)
class UsersServiceTest {

	@Autowired
	UserService us;
	
	int id;

	@Test
	@Order(1)
	@Commit
	public void createUser() {
		Users u = new Users();
		u.setId(0);
		u.setName("User1");
		u.setPassword("password");
		u.setUsername("coolestDude1");
		u = this.us.createUser(u);
	}
	
	@Test
	@Order(2)
	void getUserById() {
		Users art = this.us.getUserById(1);
		assertTrue(art.getPassword().equals("password"));
	}
	
	@Test
	@Order(3)
	void getUserByUsername() {
		Users art = this.us.getUserByUsername("regularjoe456");
		assertTrue(art.getPassword().equals("password"));
	}
	
	@Test
	@Order(4)
	@Rollback
	void updateUser() {
		Users art = this.us.getUserById(1);
		art.setName("wow");
		this.us.updateUser(art);
		
		Users art2 = this.us.getUserById(1);
		assertTrue(art2.getName().equals("wow"));
	}
	
	
	
	@Test
	@Order(5)
	@Commit
	void deleteUser() {
		Users u = this.us.getUserByUsername("coolestDude1");
		this.us.deleteUser(u);
		assertNull(this.us.getUserByUsername("coolestDude1"));
		
	}

}
