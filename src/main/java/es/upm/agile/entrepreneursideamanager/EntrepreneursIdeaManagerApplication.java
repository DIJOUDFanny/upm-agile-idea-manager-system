package es.upm.agile.entrepreneursideamanager;

import es.upm.agile.entrepreneursideamanager.model.entities.Idea;
import es.upm.agile.entrepreneursideamanager.model.entities.IdeaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EntrepreneursIdeaManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrepreneursIdeaManagerApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
