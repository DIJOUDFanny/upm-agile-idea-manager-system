package es.upm.agile.entrepreneursideamanager.controllers.rest;

import es.upm.agile.entrepreneursideamanager.domain.Idea;
import es.upm.agile.entrepreneursideamanager.exceptions.IdeaNotFoundException;
import es.upm.agile.entrepreneursideamanager.services.IdeaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ideas")
public class IdeaController {

  @Autowired
  private IdeaService ideaService;
  
  @GetMapping("")
  public List<Idea> all() {
    return ideaService.findAll();
  }

  @GetMapping("/{id}")
  public Idea getIdea(@PathVariable Long id) {
	  Idea idea = ideaService.findById(id);
	  if(idea == null) {
		  throw new IdeaNotFoundException(id);
	  }
    return idea;
  }

  @PostMapping("")
  public Idea create(@RequestBody Idea newIdea) {
    return ideaService.save(newIdea);
  }

  @PutMapping("/{id}")
  public Idea replace(@RequestBody Idea newIdea, @PathVariable Long id) {
	newIdea.setId(id);
	return ideaService.save(newIdea);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
	  ideaService.deleteById(id);
  }
}
