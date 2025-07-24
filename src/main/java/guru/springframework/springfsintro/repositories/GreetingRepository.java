package guru.springframework.springfsintro.repositories;

import guru.springframework.springfsintro.entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Integer> {
    // Spring Data JPA will automatically implement CRUD operations
}