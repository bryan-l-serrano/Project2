package dev.tasacdws.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Project2BackendApplication;

import dev.tasacdws.services.ArtistService;
import dev.tasacdws.services.UserService;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = Project2BackendApplication.class)
class ArtistServiceTest {
	
	@Autowired
	ArtistService as;

	@Test
	void createArtist() {
		fail("Not yet implemented");
	}
	
	@Test
	void getArtistById() {
		fail("Not yet implemented");
	}
	
	@Test
	void getArtistByUsername() {
		fail("Not yet implemented");
	}
	
	@Test
	void getArtistByUsernameAndPassword() {
		fail("Not yet implemented");
	}
	
	@Test
	void updateArtist() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void deleteArtist() {
		fail("Not yet implemented");
	}

}
