package es.upm.agile.entrepreneursideamanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.upm.agile.entrepreneursideamanager.domain.Idea;

@Service
public interface IdeaService {

	List<Idea> findAll();

	Idea findById(Long id);

	Idea save(Idea idea);

	void deleteById(Long id);


}
