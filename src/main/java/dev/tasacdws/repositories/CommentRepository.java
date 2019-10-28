package dev.tasacdws.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.tasacdws.entities.Comment;

@Component
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
