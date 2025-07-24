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
            return new GreetingDto("not found");
        }
        
        Greeting greeting = greetings.getFirst();
        return new GreetingDto(greeting.getId(), greeting.getGreeting());
    }
}