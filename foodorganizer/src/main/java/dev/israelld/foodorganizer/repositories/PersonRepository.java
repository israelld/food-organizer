package dev.israelld.foodorganizer.repositories;

import dev.israelld.foodorganizer.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
