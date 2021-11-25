package es.upm.agile.entrepreneursideamanager.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.upm.agile.entrepreneursideamanager.domain.Comment;
import es.upm.agile.entrepreneursideamanager.domain.Idea;
import es.upm.agile.entrepreneursideamanager.exceptions.CommentNotFoundException;
import es.upm.agile.entrepreneursideamanager.exceptions.IdeaNotFoundException;
import es.upm.agile.entrepreneursideamanager.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("")
	public List<Comment> getAll(){
		return commentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Comment getComment(@PathVariable Long id) {
		Comment Comment = commentService.findById(id);
		if(Comment == null) {
			throw new CommentNotFoundException(id);
		}
		return Comment;
	}

	@PostMapping("")
	public Comment create(@RequestBody Comment newComment) {
		return commentService.save(newComment);
	}

	@PutMapping("/{id}")
	public Comment replace(@RequestBody Comment newComment, @PathVariable Long id) {
		newComment.setId(id);
		return commentService.save(newComment);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		commentService.deleteById(id);
	}

}
