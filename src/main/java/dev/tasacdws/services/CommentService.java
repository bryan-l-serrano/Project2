package dev.tasacdws.services;

import java.util.Set;

import dev.tasacdws.entities.Comment;
import dev.tasacdws.entities.TemporaryComment;

public interface CommentService {
	
	// Create
	Comment createComment(Comment comment);
	
	// Read
	Comment getCommentById(int id);
	Set<TemporaryComment> getAllCommentsBySongId(int id);
	Set<Comment> getAllCommentsByUserId(int id);
	
	// Update
	Comment updateComment(Comment comment);
	
	// Delete
	boolean deleteComment(Comment comment);

}
