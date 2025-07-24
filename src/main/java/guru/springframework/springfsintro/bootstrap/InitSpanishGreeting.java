package guru.springframework.springfsintro.bootstrap;

import guru.springframework.springfsintro.entities.Greeting;
import guru.springframework.springfsintro.repositories.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Initializes the database with a Spanish greeting when profile is "spanish"
 */
@Component
@Profile("spanish")
public class InitSpanishGreeting implements CommandLineRunner {

    private final GreetingRepository greetingRepository;

    public InitSpanishGreeting(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Save Spanish greeting to database
        Greeting spanishGreeting = new Greeting("Hola Mundo");
        greetingRepository.save(spanishGreeting);
        
        System.out.println("Initialized database with Spanish greeting");
    }
}