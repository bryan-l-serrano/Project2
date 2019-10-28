package dev.tasacdws.services;

import java.util.Set;

import dev.tasacdws.entities.Comment;

public interface CommentService {
	
	// Create
	Comment createComment(Comment comment);
	
	// Read
	Comment getCommentById(int id);
	Set<Comment> getAllCommentsBySongId();
	Set<Comment> getAllCommentsByUserId();
	
	// Update
	Comment updateComment(Comment comment);
	
	// Delete
	boolean deleteComment(Comment comment);

}
