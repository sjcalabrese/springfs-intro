package guru.springframework.springfsintro.controller;

import guru.springframework.springfsintro.model.GreetingDto;
import guru.springframework.springfsintro.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for Greeting operations
 */
@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("api/v1/greeting")
    public GreetingDto getGreeting() {
        return greetingService.getGreeting();
    }
}