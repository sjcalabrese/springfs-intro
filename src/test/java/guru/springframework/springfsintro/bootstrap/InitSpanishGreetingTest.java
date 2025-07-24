package guru.springframework.springfsintro.bootstrap;

import guru.springframework.springfsintro.entities.Greeting;
import guru.springframework.springfsintro.repositories.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test to verify Spanish greeting is saved when "spanish" profile is active
 */
@SpringBootTest
@ActiveProfiles("spanish")
class InitSpanishGreetingTest {

    @Autowired
    GreetingRepository greetingRepository;

    @Test
    void testSpanishGreetingInitialized() {
        // Get all greetings from the database
        List<Greeting> greetings = greetingRepository.findAll();
        
        // Verify at least one greeting exists
        assertThat(greetings).isNotEmpty();
        
        // Find a greeting with "Hola Mundo" text
        boolean hasSpanishGreeting = greetings.stream()
                .anyMatch(greeting -> "Hola Mundo".equals(greeting.getGreeting()));
        
        // Verify the Spanish greeting exists
        assertThat(hasSpanishGreeting).isTrue();
    }
}