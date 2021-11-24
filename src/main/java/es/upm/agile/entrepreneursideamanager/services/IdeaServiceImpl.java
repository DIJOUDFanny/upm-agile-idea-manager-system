package es.upm.agile.entrepreneursideamanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upm.agile.entrepreneursideamanager.domain.Idea;
import es.upm.agile.entrepreneursideamanager.repositories.IdeaRepository;

@Service
public class IdeaServiceImpl implements IdeaService {

	private IdeaRepository ideaRepository;
	
	@Autowired
	public IdeaServiceImpl(IdeaRepository ideaRepository) {
		this.ideaRepository=ideaRepository;
	}

	@Override
	public List<Idea> findAll() {
		return ideaRepository.findAll();
	}

	@Override
	public Idea findById(Long id) {
		Optional<Idea> idea= ideaRepository.findById(id);
		if(idea.isPresent()) {
			return idea.get();
		}
		return null;
	}

	@Override
	public Idea save(Idea idea) {
		return ideaRepository.save(idea);
	}

	@Override
	public void deleteById(Long id) {
		ideaRepository.deleteById(id);
	}

}
