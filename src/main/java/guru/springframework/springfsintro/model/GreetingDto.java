package guru.springframework.springfsintro.model;

public class GreetingDto {

    private Integer id;
    private String greeting;
    
    public GreetingDto() {
    }

    public GreetingDto(String greeting) {
        this.greeting = greeting;
    }

    public GreetingDto(Integer id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }

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