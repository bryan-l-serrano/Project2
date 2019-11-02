package dev.tasacdws.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.tasacdws.entities.Comment;
import dev.tasacdws.entities.TemporaryComment;
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

	@Override
	public Set<TemporaryComment> getAllCommentsBySongId(int id) {
		Set<Comment> comments = sr.findById(id).get().getComments();
		Set<TemporaryComment> tc = new HashSet<TemporaryComment>();
		
		for(Comment c : comments) {
			TemporaryComment newCom = new TemporaryComment();
			newCom.setId(c.getId());
			newCom.setComment(c.getComment());
			newCom.setRating(c.getRating());
			newCom.setSong(c.getSong().getId());
			newCom.setUser(c.getUser().getId());
			tc.add(newCom);
		}
		return tc;
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
