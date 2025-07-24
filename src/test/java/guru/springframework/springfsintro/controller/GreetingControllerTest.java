package guru.springframework.springfsintro.controller;

import guru.springframework.springfsintro.model.GreetingDto;
import guru.springframework.springfsintro.services.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GreetingControllerTest {

    @Mock
    GreetingService greetingService;

    @InjectMocks
    GreetingController greetingController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
    }

    @Test
    void testGetGreeting() throws Exception {
        // Given
        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setId(1);
        greetingDto.setGreeting("Hello, World!");
        
        when(greetingService.getGreeting()).thenReturn(greetingDto);
        
        // When/Then
        mockMvc.perform(get("/api/v1/greeting")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.greeting").value("Hello, World!"));
        
        verify(greetingService, times(1)).getGreeting();
    }

    @Test
    void testGetGreetingNotFound() throws Exception {
        // Given
        GreetingDto notFoundDto = new GreetingDto();
        notFoundDto.setGreeting("not found");
        
        when(greetingService.getGreeting()).thenReturn(notFoundDto);
        
        // When/Then
        mockMvc.perform(get("/api/v1/greeting")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.greeting").value("not found"));
        
        verify(greetingService, times(1)).getGreeting();
    }
}