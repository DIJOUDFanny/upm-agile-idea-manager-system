package es.upm.agile.entrepreneursideamanager.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea, Long> {}
