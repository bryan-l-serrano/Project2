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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Project2BackendApplication;

import dev.tasacdws.entities.Comment;
import dev.tasacdws.services.CommentService;
import dev.tasacdws.services.SongService;
import dev.tasacdws.services.UserService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = Project2BackendApplication.class)
class CommentServiceTest {
	
	@Autowired
	CommentService cs;
	
	@Autowired
	SongService ss;
	
	@Autowired
	UserService us;

	// Works
	@Test
	@Order(1)
	@Commit
	public void createComment() {
		Comment comment = new Comment();
		comment.setId(0);
		comment.setComment("Adam Ranieri");
		comment.setRating(2);
		comment.setSong(this.ss.getSongById(1));
		comment.setUser(this.us.getUserById(1));
		comment = this.cs.createComment(comment);
	}
	
	// Works
	@Test
	@Order(2)
	public void getCommentById() {
		Comment comment = this.cs.getCommentById(1);
		assertTrue(comment.getComment().equals("Yooooooooooo this song is dope"));
	}
	
//	@Test
//	@Order(3)
//	public void getCommentsBySongId() {
//		
//	}
	
//	@Test
//	@Order(4)
//	public void getCommentsByUserId() {
//		
//	}
	
	@Test
	@Order(5)
	@Commit
	public void updateComment() {
		Comment comment = this.cs.getCommentById(1);
		comment.setComment("Actually this song is terrible");
		comment.setRating(-1000000);
		comment = this.cs.updateComment(comment);
		
		Comment comment2 = this.cs.getCommentById(1);
		assertTrue(comment2.getComment().equals("Actually this song is terrible"));
	}
	
	@Test
	@Order(6)
	@Commit
	public void deleteComment() {
		Comment comment = this.cs.getCommentById(3);
		assertTrue(this.cs.deleteComment(comment));
	}

}
