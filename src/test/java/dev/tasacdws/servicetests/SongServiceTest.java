package dev.tasacdws.servicetests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Project2BackendApplication;

import dev.tasacdws.entities.Song;
import dev.tasacdws.services.ArtistService;
import dev.tasacdws.services.SongService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = Project2BackendApplication.class)
class SongServiceTest {
	
	@Autowired
	SongService ss;
	
	@Autowired
	ArtistService as;
	
	// username bryan
	// password password
	// artist-id 12
	
	// Works
	@Test
	@Order(1)
	@Commit
	public void createSong() {
		Song song = new Song();
		song.setId(0);
		song.setName("Test Song 2");
		song.setArtist(as.getArtistByUsername("bryan"));
		song.setInAlbum(0);
		song = this.ss.createSong(song);
//		System.out.println(as.getArtistByUsername("bryan"));
	}
	
	// Works
	@Test
	@Order(2)
	public void getSongById() {
		Song song = ss.getSongById(1);
		assertTrue(song.getName().equals("Test Song"));
	}
	
	// Works
	@Test
	@Order(3)
	public void getAllSongs() {
		Set<Song> songs = ss.getAllSongs();
		assertTrue(songs.size() > 0 && songs.size() == 5);
	}
	
	@Test
	@Order(4)
	public void getSongsByArtistId() {
		Set<Song> songs = ss.getAllSongsByArtistId(12);
		assertTrue(songs.size() == 5);
	}
	
	// Works
	@Test
	@Order(5)
	@Commit
	public void updateSong() {
		Song song = this.ss.getSongById(1);
		song.setName("Test Song 1 (Updated)");
		this.ss.updateSong(song);
		Song song2 = this.ss.getSongById(1);
		assertTrue(song2.getName().equals("Test Song 1 (Updated)"));
	}
	
	@Test
	@Order(6)
	@Commit
	public void deleteSong() {
		Song song = ss.getSongById(2);
		assertTrue(this.ss.deleteSong(song));
	}
}
