package dev.tasacdws.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.tasacdws.entities.Comment;
import dev.tasacdws.entities.TemporaryComment;
import dev.tasacdws.services.CommentService;
import dev.tasacdws.services.SongService;
import dev.tasacdws.services.UserService;

@CrossOrigin(origins = "*")
@Component
@RestController
public class CommentController {
	
	@Autowired
	CommentService cs;
	
	@Autowired
	SongService ss;
	
	@Autowired
	UserService us;
	
	// Create
//	@RequestMapping(value = "/comment/song", method = RequestMethod.POST)
//	public Comment createComment(@RequestBody Comment comment) {
//		System.out.println(comment);
//		comment = cs.createComment(comment);
//		return comment;
//	}
	
	
	// Create
		@RequestMapping(value = "/comment/song", method = RequestMethod.POST)
		public Comment createComment(@RequestBody TemporaryComment comment) {
			System.out.println(comment);
			Comment newcomment= new Comment();
			newcomment.setComment(comment.getComment());
			newcomment.setId(0);
			newcomment.setRating(comment.getRating());
			newcomment.setSong(ss.getSongById(comment.getSong()));
			newcomment.setUser(us.getUserById(comment.getUser()));
			newcomment = cs.createComment(newcomment);
			return newcomment;
		}
	
	// Read
	@RequestMapping(value = "/comment/song/{id}", method = RequestMethod.GET)
	public Set<Comment> getAllCommentsBySongId(@PathVariable int id) {
		Set<Comment> comments = cs.getAllCommentsBySongId(id);
		return comments;
	}
	
	@RequestMapping(value = "/comment/user/{id}", method = RequestMethod.GET)
	public Set<Comment> getAllCommentsByUserId(@PathVariable int id) {
		Set<Comment> comments = cs.getAllCommentsByUserId(id);
		return comments;
	}
	
	// Update
	@RequestMapping(value = "/comment", method = RequestMethod.PUT)
	public Comment updateComment(@RequestBody Comment comment) {
		Comment change = cs.getCommentById(comment.getId());
		change.setComment(comment.getComment());
		change.setRating(comment.getRating());
		cs.updateComment(change);
		return change;
	}
	
	// Delete
	@RequestMapping(value = "/comment", method = RequestMethod.DELETE)
	public boolean deleteComment(@RequestBody Comment comment) {
		boolean result = cs.deleteComment(comment);
		return result;
	}

}
