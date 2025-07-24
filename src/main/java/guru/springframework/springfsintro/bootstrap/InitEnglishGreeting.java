package guru.springframework.springfsintro.bootstrap;

import guru.springframework.springfsintro.entities.Greeting;
import guru.springframework.springfsintro.repositories.GreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Initializes the database with an English greeting when profile is not "spanish"
 */
@Component
@Profile("!spanish")
public class InitEnglishGreeting implements CommandLineRunner {

    private final GreetingRepository greetingRepository;

    public InitEnglishGreeting(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Save English greeting to database
        Greeting englishGreeting = new Greeting("Hello World");
        greetingRepository.save(englishGreeting);
        
        System.out.println("Initialized database with English greeting");
    }
}