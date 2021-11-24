package es.upm.agile.entrepreneursideamanager.exceptions;

public class CommentNotFoundException extends RuntimeException{

	public CommentNotFoundException(Long id) {
	    super(String.format("Could not find comment #%s", id));
	}
}
