package dev.israelld.hotomfop.repositories;

import dev.israelld.hotomfop.models.Diet;
import dev.israelld.hotomfop.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByDiet(Diet diet);

}
