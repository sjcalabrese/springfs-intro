package guru.springframework.springfsintro.services;

import guru.springframework.springfsintro.model.GreetingDto;

/**
 * Service interface for handling Greeting operations
 */
public interface GreetingService {
    
    /**
     * Retrieves a greeting
     * @return GreetingDto object
     */
    GreetingDto getGreeting();
}