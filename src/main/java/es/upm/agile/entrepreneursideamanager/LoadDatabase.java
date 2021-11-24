package es.upm.agile.entrepreneursideamanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.upm.agile.entrepreneursideamanager.domain.Idea;
import es.upm.agile.entrepreneursideamanager.repositories.IdeaRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(IdeaRepository ideaRepository) {
    return args -> {
      log.info("Preloading {}", ideaRepository.save(new Idea("Test idea 1", "I'm an idea, yeah!")));
      log.info("Preloading {}", ideaRepository.save(new Idea("Test idea 2", "I'm an other idea!")));
    };
  }
}