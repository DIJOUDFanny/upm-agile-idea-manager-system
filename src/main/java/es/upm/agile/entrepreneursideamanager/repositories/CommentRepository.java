package es.upm.agile.entrepreneursideamanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.agile.entrepreneursideamanager.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
