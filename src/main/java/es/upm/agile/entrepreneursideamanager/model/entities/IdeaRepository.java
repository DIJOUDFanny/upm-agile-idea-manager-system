package es.upm.agile.entrepreneursideamanager.model.entities;

import org.springframework.data.repository.CrudRepository;

public interface IdeaRepository extends CrudRepository<Idea, Long> {

    Idea findById(long id);
}
