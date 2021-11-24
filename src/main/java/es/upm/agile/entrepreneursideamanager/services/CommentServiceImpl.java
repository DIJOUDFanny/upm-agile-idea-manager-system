package es.upm.agile.entrepreneursideamanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.agile.entrepreneursideamanager.domain.Comment;
import es.upm.agile.entrepreneursideamanager.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;
	
	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findById(Long id) {
		Optional<Comment> comment= commentRepository.findById(id);
		if(comment.isPresent()) {
			return comment.get();
		}
		return null;
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void deleteById(Long id) {
		commentRepository.deleteById(id);
	}

}
