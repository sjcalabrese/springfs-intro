package guru.springframework.springfsintro.repositories;

import guru.springframework.springfsintro.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GreetingRepositoryTest {

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    void testSaveGreeting() {
        // Create a new greeting
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello, Spring Data JPA!");

        // Save the greeting
        Greeting savedGreeting = greetingRepository.save(greeting);

        // Verify the greeting was saved with an ID
        assertThat(savedGreeting.getId()).isNotNull();
        assertThat(savedGreeting.getGreeting()).isEqualTo("Hello, Spring Data JPA!");
    }

    @Test
    void testFindGreetingById() {
        // Create and save a greeting
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello, Find By ID!");
        Greeting savedGreeting = greetingRepository.save(greeting);

        // Find the greeting by ID
        Optional<Greeting> foundGreeting = greetingRepository.findById(savedGreeting.getId());

        // Verify the greeting was found
        assertThat(foundGreeting).isPresent();
        assertThat(foundGreeting.get().getGreeting()).isEqualTo("Hello, Find By ID!");
    }

    @Test
    void testUpdateGreeting() {
        // Create and save a greeting
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello, Before Update!");
        Greeting savedGreeting = greetingRepository.save(greeting);

        // Update the greeting
        savedGreeting.setGreeting("Hello, After Update!");
        Greeting updatedGreeting = greetingRepository.save(savedGreeting);

        // Verify the greeting was updated
        assertThat(updatedGreeting.getId()).isEqualTo(savedGreeting.getId());
        assertThat(updatedGreeting.getGreeting()).isEqualTo("Hello, After Update!");
    }

    @Test
    void testDeleteGreeting() {
        // Create and save a greeting
        Greeting greeting = new Greeting();
        greeting.setGreeting("Hello, Delete Me!");
        Greeting savedGreeting = greetingRepository.save(greeting);

        // Delete the greeting
        greetingRepository.deleteById(savedGreeting.getId());

        // Verify the greeting was deleted
        Optional<Greeting> deletedGreeting = greetingRepository.findById(savedGreeting.getId());
        assertThat(deletedGreeting).isEmpty();
    }

    @Test
    void testFindAllGreetings() {
        // Clear any existing data
        greetingRepository.deleteAll();

        // Create and save multiple greetings
        Greeting greeting1 = new Greeting();
        greeting1.setGreeting("Hello, Greeting 1!");
        greetingRepository.save(greeting1);

        Greeting greeting2 = new Greeting();
        greeting2.setGreeting("Hello, Greeting 2!");
        greetingRepository.save(greeting2);

        // Find all greetings
        List<Greeting> greetings = greetingRepository.findAll();

        // Verify all greetings were found
        assertThat(greetings).hasSize(2);
        assertThat(greetings).extracting(Greeting::getGreeting)
                .containsExactlyInAnyOrder("Hello, Greeting 1!", "Hello, Greeting 2!");
    }
}