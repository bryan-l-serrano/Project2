package dev.tasacdws.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.tasacdws.entities.Comment;
import dev.tasacdws.repositories.CommentRepository;
import dev.tasacdws.repositories.SongRepository;
import dev.tasacdws.repositories.UsersRepository;

@Component
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository cr;
	
	@Autowired
	UsersRepository ur;
	
	@Autowired
	SongRepository sr;

	@Override
	public Comment createComment(Comment comment) {
		comment = cr.save(comment);
		return comment;
	}

	@Override
	public Comment getCommentById(int id) {
		Comment comment = cr.findById(id).get();
		return comment;
	}

	/*
	 * THESE ARE NOT YET IMPLEMENTED
	 */
	@Override
	public Set<Comment> getAllCommentsBySongId(int id) {
		Set<Comment> comments = sr.findById(id).get().getComments();
		return comments;
	}

	@Override
	public Set<Comment> getAllCommentsByUserId(int id) {
		Set<Comment> comments = ur.findById(id).get().getComments();
		return comments;
	}
	/*
	 * 
	 */

	@Override
	public Comment updateComment(Comment comment) {
		comment = cr.save(comment);
		return comment;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		try {
			cr.delete(comment);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
