package dev.israelld.foodorganizer.repositories;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {

    List<Diet> findByPerson(Person person);

}
