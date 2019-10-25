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

import dev.tasacdws.entities.Artist;
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
	
	int id;

	@Test
	@Order(1)
	@Commit
	public void createArtist() {
		Artist art = new Artist();
		art.setId(0);
		art.setName("New Artist");
		art.setPassword("password");
		art.setUsername("coolerDude");
		art = this.as.createArtist(art);
		id = art.getId();
		System.out.println(id);
	}
	
	@Test
	@Order(2)
	void getArtistById() {
		Artist art = this.as.getArtistById(id);
		assertTrue(art.getPassword().equals("password"));
	}
	
	@Test
	@Order(3)
	void getArtistByUsername() {
		Artist art = this.as.getArtistByUsername("coolerDude");
		assertTrue(art.getName().equals("New Artist"));
	}
	
//	@Test
//	@Order(4)
//	void getArtistByUsernameAndPassword() {
//		Artist art = this.as.getArtistByUsernameAndPassword("coolerDude", "password");
//		assertTrue(art.getName().equals("New Artist"));
//	}
//	
	
	@Test
	@Order(4)
	void updateArtist() {
		Artist art = this.as.getArtistByUsername("coolerDude");
		art.setName("wow");
		this.as.updateArtist(art);
		
		Artist art2 = this.as.getArtistByUsername("coolerDude");
		assertTrue(art2.getName().equals("wow"));
	}
	
	
	
	@Test
	@Order(5)
	@Commit
	void deleteArtist() {
		Artist art = this.as.getArtistByUsername("coolerDude");
		this.as.deleteArtist(art);
		assertNull(this.as.getArtistByUsername("coolerDude"));
		
	}

}
