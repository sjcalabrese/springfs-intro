package guru.springframework.springfsintro.services;

import guru.springframework.springfsintro.entities.Greeting;
import guru.springframework.springfsintro.model.GreetingDto;
import guru.springframework.springfsintro.repositories.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GreetingServiceImplTest {

    @Mock
    GreetingRepository greetingRepository;

    GreetingService greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingServiceImpl(greetingRepository);
    }

    @Test
    void getGreetingWithData() {
        // Given
        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setGreeting("Hello, World!");

        List<Greeting> greetings = new ArrayList<>();
        greetings.add(greeting);

        when(greetingRepository.findAll()).thenReturn(greetings);

        // When
        GreetingDto result = greetingService.getGreeting();

        // Then
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Hello, World!", result.getGreeting());
        verify(greetingRepository, times(1)).findAll();
    }

    @Test
    void getGreetingWithEmptyList() {
        // Given
        when(greetingRepository.findAll()).thenReturn(new ArrayList<>());

        // When
        GreetingDto result = greetingService.getGreeting();

        // Then
        assertNotNull(result);
        assertNull(result.getId());
        assertEquals("not found", result.getGreeting());
        verify(greetingRepository, times(1)).findAll();
    }
}