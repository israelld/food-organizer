package dev.israelld.hotomfop.repositories;

import dev.israelld.hotomfop.models.Diet;
import dev.israelld.hotomfop.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {

    List<Diet> findByPerson(Person person);

}
