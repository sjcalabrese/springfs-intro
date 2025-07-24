package guru.springframework.springfsintro.model;

/**
 * Data Transfer Object for Greeting entity
 */
public class GreetingDto {

    private Integer id;
    private String greeting;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}