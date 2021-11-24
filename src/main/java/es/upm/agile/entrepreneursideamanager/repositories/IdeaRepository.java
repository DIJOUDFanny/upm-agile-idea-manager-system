package es.upm.agile.entrepreneursideamanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.agile.entrepreneursideamanager.domain.Idea;

public interface IdeaRepository extends JpaRepository<Idea, Long> {}
