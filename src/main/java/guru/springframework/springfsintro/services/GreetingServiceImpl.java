package guru.springframework.springfsintro.services;

import guru.springframework.springfsintro.entities.Greeting;
import guru.springframework.springfsintro.model.GreetingDto;
import guru.springframework.springfsintro.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of GreetingService
 */
@Service
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public GreetingDto getGreeting() {
        List<Greeting> greetings = greetingRepository.findAll();
        
        if (greetings.isEmpty()) {
            // Return a new GreetingDto with "not found" message if no records exist
            GreetingDto notFoundDto = new GreetingDto();
            notFoundDto.setGreeting("not found");
            return notFoundDto;
        }
        
        // Get the first greeting from the list
        Greeting greeting = greetings.getFirst();
        
        // Convert entity to DTO
        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setId(greeting.getId());
        greetingDto.setGreeting(greeting.getGreeting());
        
        return greetingDto;
    }
}