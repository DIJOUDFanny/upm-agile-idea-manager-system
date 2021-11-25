package es.upm.agile.entrepreneursideamanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.upm.agile.entrepreneursideamanager.domain.Comment;


@Service
public interface CommentService {

	List<Comment> findAll();

	Comment findById(Long id);

	Comment save(Comment comment);

	void deleteById(Long id);
}
