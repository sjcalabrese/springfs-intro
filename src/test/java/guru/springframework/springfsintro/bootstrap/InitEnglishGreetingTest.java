package guru.springframework.springfsintro.bootstrap;

import guru.springframework.springfsintro.entities.Greeting;
import guru.springframework.springfsintro.repositories.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test to verify English greeting is saved when no profile is active
 */
@SpringBootTest
class InitEnglishGreetingTest {

    @Autowired
    GreetingRepository greetingRepository;

    @Test
    void testEnglishGreetingInitialized() {
        // Get all greetings from the database
        List<Greeting> greetings = greetingRepository.findAll();
        
        // Verify at least one greeting exists
        assertThat(greetings).isNotEmpty();
        
        // Find a greeting with "Hello World" text
        boolean hasEnglishGreeting = greetings.stream()
                .anyMatch(greeting -> "Hello World".equals(greeting.getGreeting()));
        
        // Verify the English greeting exists
        assertThat(hasEnglishGreeting).isTrue();
    }
}