package es.upm.agile.entrepreneursideamanager.controllers;

import es.upm.agile.entrepreneursideamanager.IdeaNotFoundException;
import es.upm.agile.entrepreneursideamanager.model.Idea;
import es.upm.agile.entrepreneursideamanager.model.IdeaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@V1APIController
public class IdeaController {

  private final IdeaRepository repository;

  IdeaController(IdeaRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/ideas")
  public List<Idea> all() {
    return repository.findAll();
  }

  @GetMapping("/ideas/{id}")
  public Idea one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new IdeaNotFoundException(id));
  }

  @PostMapping("/ideas")
  public Idea create(@RequestBody Idea newIdea) {
    return repository.save(newIdea);
  }

  @PutMapping("/ideas/{id}")
  public Idea replace(@RequestBody Idea newIdea, @PathVariable Long id) {
    return repository
        .findById(id)
        .map(
            idea -> {
              idea.setName(newIdea.getName());
              idea.setDescription(newIdea.getDescription());
              return repository.save(idea);
            })
        .orElseGet(
            () -> {
              newIdea.setId(id);
              return repository.save(newIdea);
            });
  }

  @DeleteMapping("/ideas/{id}")
  public void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
